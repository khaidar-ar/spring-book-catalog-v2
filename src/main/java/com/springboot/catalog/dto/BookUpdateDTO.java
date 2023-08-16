package com.springboot.catalog.dto;

import lombok.Data;

@Data
public class BookUpdateDTO {
    private String bookTitle;
    private String bookDescription;
}
