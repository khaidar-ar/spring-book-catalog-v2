package com.springboot.catalog.service;

import com.springboot.catalog.dto.BookCreateResponseDTO;
import com.springboot.catalog.dto.BookDetailDTO;
import com.springboot.catalog.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {


    public void createBookDTO(BookCreateResponseDTO bookDetailDTO);

}
