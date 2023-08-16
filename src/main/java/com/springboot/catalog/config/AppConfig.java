//package com.springboot.catalog.config;
//
//
//import com.springboot.catalog.domain.Author;
//import com.springboot.catalog.domain.Book;
//import com.springboot.catalog.repository.BookRepository;
//import com.springboot.catalog.repository.impl.BookRepositoryImplNonJpa;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
////@ComponentScan("com.springboot.catalog") unused with spring-boot
//public class AppConfig {
//    @Bean
//    public Author author1() {
//        Author author = new Author();
//        author.setId(1L);
//        author.setName("M. Pierce");
//        return author;
//    }
//
//    @Bean
//    public Author author2() {
//        Author author = new Author();
//        author.setId(2L);
//        author.setName("Aleatha Romig");
//        return author;
//    }
//
//    @Bean
//    public Book book1(Author author1) {
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("Night Owl");
//        book.setDescription("Night Owl by M. Pierce");
////        book.setAuthor(author1);
//        return book;
//    }
//
//    @Bean
//    public Book book2(Author author2) {
//        Book book = new Book();
//        book.setId(2L);
//        book.setTitle("Consequences");
//        book.setDescription("Consequences by Aleatha Romig");
////        book.setAuthor(author2);
//        return book;
//    }
//
//    @Bean
//    public BookRepository bookRepository(Book book1, Book book2) {
//        Map<Long, Book> bookMap = new HashMap<Long, Book>();
//        bookMap.put(1L, book1(author1()));
//        bookMap.put(2L, book2(author2()));
//        BookRepositoryImplNonJpa bookRepository = new BookRepositoryImplNonJpa();
//        bookRepository.setBookMap(bookMap);
//        return bookRepository;
//    }
//}
