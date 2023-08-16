package com.springboot.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookCreateResponseDTO {
    @NotBlank
    private String bookTitle;

    @NotEmpty
    private List<String> authorList;

    @NotEmpty
    private List<String> categoryList;

    @NotEmpty
    private String publisherId;
    private String bookDescription;
}
