package com.springboot.catalog.service;

import com.springboot.catalog.domain.Publisher;
import com.springboot.catalog.dto.PublisherCreateDTO;
import com.springboot.catalog.dto.PublisherListResponseDTO;
import com.springboot.catalog.dto.PublisherUpdateDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;
import org.springframework.data.domain.Page;

public interface PublisherService {

    public void createPublisher(PublisherCreateDTO dto);

    public Publisher findPublisherId(String id);

    public void updatePublisher(String id, PublisherUpdateDTO dto);

    public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer contents,
                                                                             String sortBy, String direction,
                                                                             String publisherName);
}
