package com.resatoAPI.com.web;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("resto/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

   @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody @Validated CategoryDTO dto){
        return  ResponseEntity.ok(categoryService.save(dto));

    }
}
