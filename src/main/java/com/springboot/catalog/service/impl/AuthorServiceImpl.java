package com.springboot.catalog.service.impl;

import com.springboot.catalog.domain.Author;
import com.springboot.catalog.dto.AuthorCreateDTO;
import com.springboot.catalog.dto.AuthorResponseDTO;
import com.springboot.catalog.dto.AuthorUpdateDTO;
import com.springboot.catalog.exception.BadRequestException;
import com.springboot.catalog.repository.AuthorRepository;
import com.springboot.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(String id) {
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new BadRequestException("invalid id"));
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createAuthor(AuthorCreateDTO dto) {
        Author author = new Author();
        author.setName(dto.getAuthorName());
        author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(String id, AuthorUpdateDTO dto) {
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new BadRequestException("invalid id"));
        author.setName(dto.getName() != null ? dto.getName() : author.getName());
        author.setBirthDate(dto.getBirthDate() == null ? author.getBirthDate() :
                LocalDate.ofEpochDay(dto.getBirthDate()));
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String id) {
//        hard delete

        Author author = authorRepository.findBySecureId(id).orElseThrow(() ->
                new BadRequestException("invalid secure id")
        );
        authorRepository.delete(author);

//        soft delete
//       1. select data where deleted == false
//        2. update -> deleted == true
//        Author author = authorRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new BadRequestException(
//                "invalid id or deleted != false"));
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);
    }

    @Override
    public List<Author> findAuthors(List<String> idList) {
        List<Author> authors = authorRepository.findBySecureIdIn(idList);
        if (authors.isEmpty()) {
            throw new BadRequestException("Authors can't be empty");
        }
        return authors;
    }
}
