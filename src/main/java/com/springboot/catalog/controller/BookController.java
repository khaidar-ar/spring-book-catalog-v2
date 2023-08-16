//package com.springboot.catalog.controller;
//
//import com.springboot.catalog.dto.BookCreateResponseDTO;
//import com.springboot.catalog.dto.BookDetailDTO;
//import com.springboot.catalog.dto.BookUpdateDTO;
//import com.springboot.catalog.service.BookService;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.util.List;
//
//@AllArgsConstructor
//public class BookController {
//    private final BookService bookService;
//
//    //    @GetMapping("/book/list")
//    @GetMapping("/list")
//    public String findBookList(Model model) {
//        List<BookDetailDTO> books = bookService.findBookListDTO();
//        model.addAttribute("books", books);
//        return "book/list";
//    }
//
//    //    @GetMapping("/book/new")
//    @GetMapping("/new")
//    public String loadNewBook(Model model) {
//        BookCreateResponseDTO dto = new BookCreateResponseDTO();
//        model.addAttribute("bookCreateDTO", dto);
//        return "book/book-new";
//    }
//
//    @PostMapping("/new")
//    public String insertBook(@ModelAttribute("bookCreateDTO") @Valid BookCreateResponseDTO bookCreateDTO, BindingResult bindingResult, Model model, Errors errors) {
//        if (errors.hasErrors()) {
//            model.addAttribute("bookCreateDTO", bookCreateDTO);
//            return "book/book-new";
//        }
////        bookService.insertBookDTO(bookCreateDTO);
//        return "redirect:book/list";
//    }
//
//    //restful api using post man with responseEntity
//    @PostMapping("/json/new")
//    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateResponseDTO dto) {
////        bookService.insertBookDTO(dto);
//        return ResponseEntity.created(URI.create("/json/new")).build();
//    }
//
//    @GetMapping("/json/list")
//    public ResponseEntity<List<BookDetailDTO>> getBooks() {
//        return ResponseEntity.ok().body(bookService.findBookListDTO());
//    }
//
//    @PutMapping("/json/{bookId}")
//    public ResponseEntity<Void> updateBook(@PathVariable("bookId") long id, BookUpdateDTO bookUpdateDTO) {
//        bookService.updateBook(id, bookUpdateDTO);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/json/{bookId}")
//    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") long id) {
//        bookService.deleteBook(id);
//        return ResponseEntity.ok().build();
//    }
//}
