package com.springboot.catalog.service.impl;

import com.springboot.catalog.domain.Author;
import com.springboot.catalog.domain.Book;
import com.springboot.catalog.domain.Category;
import com.springboot.catalog.domain.Publisher;
import com.springboot.catalog.dto.BookCreateResponseDTO;
import com.springboot.catalog.dto.BookDetailDTO;
import com.springboot.catalog.dto.BookUpdateDTO;
import com.springboot.catalog.repository.BookRepository;
import com.springboot.catalog.service.AuthorService;
import com.springboot.catalog.service.BookService;
import com.springboot.catalog.service.CategoryService;
import com.springboot.catalog.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;



    @Override
    public void createBookDTO(BookCreateResponseDTO dto) {
        List<Author> authors = authorService.findAuthors(dto.getAuthorList());
        List<Category> categories = categoryService.findCategories(dto.getCategoryList());
        Publisher publisher = publisherService.findPublisherId(dto.getPublisherId());
        Book book = new Book();
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getBookDescription());
        bookRepository.save(book);
    }

}
