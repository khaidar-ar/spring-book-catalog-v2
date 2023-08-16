package com.springboot.catalog.repository;

import com.springboot.catalog.domain.Book;

import java.util.List;

public interface BookRepositoryNonJpa {
    public Book findBookById(long id);

    public List<Book> findAll();

    public void save(Book book);
    public void update(Book book);

    public void delete(long id);
}
