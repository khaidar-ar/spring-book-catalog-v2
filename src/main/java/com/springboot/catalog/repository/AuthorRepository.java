package com.springboot.catalog.repository;

import com.springboot.catalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Optional<Author> findById(Long id);

    public Optional<Author> findBySecureId(String id);

    public List<Author> findBySecureIdIn(List<String> idList);


    public Optional<Author> findByIdAndDeletedFalse(Long id);

    public List<Author> findByNameLike(String name);
}
