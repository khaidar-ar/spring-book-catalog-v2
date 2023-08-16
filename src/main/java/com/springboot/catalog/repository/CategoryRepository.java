package com.springboot.catalog.repository;

import com.springboot.catalog.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, String> {

    public Optional<Category> findByCode(String code);

    public Page<Category> findByNameLikeIgnoreCase(String name, Pageable pageable);

    public List<Category> findByCodeIn(List<String> codes);
}
