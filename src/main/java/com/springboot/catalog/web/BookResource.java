package com.springboot.catalog.web;

import com.springboot.catalog.dto.BookCreateResponseDTO;
import com.springboot.catalog.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/v2")
public class BookResource {

    private final BookService bookService;

//    @PostMapping("/book/{bookId}")
//    public BookDetailDTO findBookById(@PathVariable("bookId") long id) {
//        return bookService.findBookDTO(id);
//    }

    @PostMapping("/books")
    public ResponseEntity<Void> createBook(@RequestBody @Valid BookCreateResponseDTO dto) {
        bookService.createBookDTO(dto);
        return ResponseEntity.created(URI.create("/books")).build();
    }
}
