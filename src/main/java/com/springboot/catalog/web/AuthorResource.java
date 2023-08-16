package com.springboot.catalog.web;

import com.springboot.catalog.dto.AuthorCreateDTO;
import com.springboot.catalog.dto.AuthorResponseDTO;
import com.springboot.catalog.dto.AuthorUpdateDTO;
import com.springboot.catalog.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/v2")
public class AuthorResource {
    private final AuthorService authorService;

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable String id) {
        AuthorResponseDTO dto = authorService.findAuthorById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/author")
    public ResponseEntity<Void> insertAuthor(@RequestBody @Valid AuthorCreateDTO dto) {
        authorService.createAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String id, @RequestBody AuthorUpdateDTO dto) {
        authorService.updateAuthor(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
