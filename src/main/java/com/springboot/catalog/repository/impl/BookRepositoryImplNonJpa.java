package com.springboot.catalog.repository.impl;

import com.springboot.catalog.domain.Book;
import com.springboot.catalog.repository.BookRepository;
import com.springboot.catalog.repository.BookRepositoryNonJpa;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Setter
public class BookRepositoryImplNonJpa implements BookRepositoryNonJpa {

    private Map<Long, Book> bookMap;

    @Override
    public Book findBookById(long id) {
        Book book = bookMap.get(id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<Book>(bookMap.values());
        return bookList;
    }

    @Override
    public void save(Book book) {
        int size = bookMap.size();
        book.setId((long) size + 1);
        bookMap.put(book.getId(), book);
    }

    public void update(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public void delete(long id) {
        bookMap.remove(id);
    }
}
