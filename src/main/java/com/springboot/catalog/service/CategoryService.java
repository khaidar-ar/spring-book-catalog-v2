package com.springboot.catalog.service;

import com.springboot.catalog.domain.Category;
import com.springboot.catalog.dto.CategoryCreateDTO;
import com.springboot.catalog.dto.CategoryListResponseDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;

import java.util.List;

public interface CategoryService {
    public void createAndUpdateCategory(CategoryCreateDTO dto);

    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer content,
                                                                           String sortBy, String direction, String name);

    public List<Category> findCategories(List<String> idList);
}
