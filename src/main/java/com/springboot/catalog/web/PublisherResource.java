package com.springboot.catalog.web;

import com.springboot.catalog.domain.Publisher;
import com.springboot.catalog.dto.PublisherCreateDTO;
import com.springboot.catalog.dto.PublisherListResponseDTO;
import com.springboot.catalog.dto.PublisherUpdateDTO;
import com.springboot.catalog.dto.ResultPageResponseDTO;
import com.springboot.catalog.service.PublisherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/v2")
public class PublisherResource {
    private final PublisherService publisherService;

    @PostMapping("/publisher")
    public ResponseEntity<Void> createNewPublisher(@RequestBody @Valid PublisherCreateDTO dto) {
        publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/publisher")).build();
    }

    @PutMapping("/publisher/{id}")
    public ResponseEntity<Void> updatePublisher(@PathVariable String id, @RequestBody @Valid PublisherUpdateDTO dto) {
        publisherService.updatePublisher(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> findPublisherList(@RequestParam(name =
            "pages", required = true, defaultValue = "0") Integer pages, @RequestParam(name = "contents", required =
            true, defaultValue = "10") Integer contents, @RequestParam(name = "sortBy", required = true,
            defaultValue = "name") String sortBy, @RequestParam(name = "direction", required = true, defaultValue =
            "asc") String direction, @RequestParam(name = "publisherName", required = false) String publisherName) {
        ResultPageResponseDTO<PublisherListResponseDTO> result = publisherService.findPublisherList(pages, contents,
                sortBy, direction, publisherName);
        return ResponseEntity.ok().body(result);
    }

}
