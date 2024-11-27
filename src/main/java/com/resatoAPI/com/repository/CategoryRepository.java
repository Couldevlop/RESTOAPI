package com.resatoAPI.com.repository;

import com.resatoAPI.com.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName (String name);
}
