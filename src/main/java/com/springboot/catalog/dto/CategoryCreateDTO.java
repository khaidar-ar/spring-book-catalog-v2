package com.springboot.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class CategoryCreateDTO {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;
}
