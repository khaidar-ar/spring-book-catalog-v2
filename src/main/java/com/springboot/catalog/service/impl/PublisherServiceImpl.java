package com.springboot.catalog.service.impl;

import com.springboot.catalog.domain.Publisher;
import com.springboot.catalog.dto.PublisherCreateDTO;
import com.springboot.catalog.dto.PublisherListResponseDTO;
import com.springboot.catalog.dto.PublisherUpdateDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;
import com.springboot.catalog.exception.BadRequestException;
import com.springboot.catalog.repository.PublisherRepository;
import com.springboot.catalog.service.PublisherService;
import com.springboot.catalog.util.PaginationUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public void createPublisher(PublisherCreateDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getPublisherName());
        publisher.setCompanyName(dto.getPublisherCompany());
        publisher.setAddress(dto.getAddress());
        publisherRepository.save(publisher);
    }

    @Override
    public Publisher findPublisherId(String id) {
        return publisherRepository.findBySecureId(id).orElseThrow(() -> new BadRequestException("publisher can't be " +
                "empty"));
    }

    @Override
    public void updatePublisher(String id, PublisherUpdateDTO dto) {
        Publisher publisher = publisherRepository.findBySecureId(id).orElseThrow(() -> new BadRequestException(
                "invalid publisher " +
                        "id"));
        publisher.setName(dto.getPublisherName() == null || dto.getPublisherName().isBlank() ? publisher.getName() :
                dto.getPublisherCompany());
        publisher.setCompanyName(dto.getPublisherCompany() == null || dto.getPublisherCompany().isBlank() ?
                publisher.getName() :
                dto.getPublisherCompany());
        publisher.setAddress(dto.getAddress());
        publisherRepository.save(publisher);
    }


    @Override
    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer contents,
                                                                             String sortBy, String direction, String publisherName) {
        publisherName = StringUtils.isBlank(publisherName) ? "%" : publisherName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.sortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, contents, sort);
        Page<Publisher> page = publisherRepository.findByNameLikeIgnoreCase(publisherName,
                pageable);
        List<PublisherListResponseDTO> dtos = page.stream().map(publisher -> {
            PublisherListResponseDTO dto = new PublisherListResponseDTO();
            dto.setPublisherName(publisher.getName());
            dto.setPublisherCompany(publisher.getCompanyName());
            dto.setPublisherId(publisher.getSecureId());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pages, contents);
    }
}
