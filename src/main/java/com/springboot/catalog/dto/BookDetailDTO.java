package com.springboot.catalog.dto;

import lombok.Data;

@Data
public class BookDetailDTO {
    private long id;
    private String bookTitle;
    private String bookAuthor;
    private String bookDescription;
}
