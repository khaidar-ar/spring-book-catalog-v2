package com.springboot.catalog.repository;

import com.springboot.catalog.domain.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public Optional<Publisher> findBySecureId(String secureId);

    public Page<Publisher> findByNameLikeIgnoreCase(String publisherName, Pageable pageable);
}
