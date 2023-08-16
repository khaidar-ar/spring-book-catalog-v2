package com.springboot.catalog.service;

import com.springboot.catalog.domain.Author;
import com.springboot.catalog.dto.AuthorCreateDTO;
import com.springboot.catalog.dto.AuthorResponseDTO;
import com.springboot.catalog.dto.AuthorUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {
    public AuthorResponseDTO findAuthorById(String id);

    public void createAuthor(AuthorCreateDTO dto);

    public void updateAuthor(String id, AuthorUpdateDTO dto);

    public void deleteAuthor(String id);

    public List<Author> findAuthors(List<String> idList);
}
