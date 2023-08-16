package com.springboot.catalog.dto;

import lombok.Data;

@Data
public class CategoryListResponseDTO {
    private String code;

    private String name;

    private String description;
}
