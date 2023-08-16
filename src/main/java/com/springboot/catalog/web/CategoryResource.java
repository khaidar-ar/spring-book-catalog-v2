package com.springboot.catalog.web;

import com.springboot.catalog.dto.CategoryCreateDTO;
import com.springboot.catalog.dto.CategoryListResponseDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;
import com.springboot.catalog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/v2")
public class CategoryResource {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Void> createAndUpdateCategory(@RequestBody @Valid CategoryCreateDTO dto) {
        categoryService.createAndUpdateCategory(dto);
        return ResponseEntity.created(URI.create("/category")).build();
    }


    @GetMapping("/category")
    public ResponseEntity<ResultPageResponseDTO<CategoryListResponseDTO>> findCategoryList(@RequestParam(name =
            "pages", required = true, defaultValue = "0") Integer pages, @RequestParam(name = "content", required = true, defaultValue = "10") Integer content, @RequestParam(name = "direction", required = true,
            defaultValue = "asc") String direction, @RequestParam(name = "sortBy", required = true,
            defaultValue = "name") String sortby, @RequestParam(name = "name", required = false) String name) {
        ResultPageResponseDTO<CategoryListResponseDTO> dto = categoryService.findCategoryList(pages, content, sortby,
                direction, name);
        return ResponseEntity.ok().body(dto);
    }
}
