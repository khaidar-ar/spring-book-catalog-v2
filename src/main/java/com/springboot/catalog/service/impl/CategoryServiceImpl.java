package com.springboot.catalog.service.impl;

import com.springboot.catalog.domain.Category;
import com.springboot.catalog.dto.CategoryCreateDTO;
import com.springboot.catalog.dto.CategoryListResponseDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;
import com.springboot.catalog.exception.BadRequestException;
import com.springboot.catalog.repository.CategoryRepository;
import com.springboot.catalog.service.CategoryService;
import com.springboot.catalog.util.PaginationUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createAndUpdateCategory(CategoryCreateDTO dto) {
        Category category = categoryRepository.findByCode(dto.getCode().toLowerCase()).orElse(new Category());
        if (category.getCode() == null) {
            category.setCode(dto.getCode().toLowerCase());
        }
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        categoryRepository.save(category);
    }

    @Override
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer content, String sortBy, String direction, String name) {
        name = StringUtils.isBlank(name) ? "%" : name + "%";
        Sort sorted = Sort.by(new Sort.Order(PaginationUtil.sortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, content, sorted);
        Page<Category> categories = categoryRepository.findByNameLikeIgnoreCase(name, pageable);
        List<CategoryListResponseDTO> dtos = categories.stream().map(category -> {
            CategoryListResponseDTO dto = new CategoryListResponseDTO();
            dto.setCode(category.getCode());
            dto.setName(category.getName());
            dto.setDescription(category.getDescription());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pages, content);
    }

    @Override
    public List<Category> findCategories(List<String> idList) {
        List<Category> categories = categoryRepository.findByCodeIn(idList);
        if (categories.isEmpty()) {
            throw new BadRequestException("categories can't be empty");
        }
        return categories;
    }
}
