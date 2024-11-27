package com.resatoAPI.com.web;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.dto.CategoryWithDishesDTO;
import com.resatoAPI.com.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/{id}/with-dishes")
    public ResponseEntity<CategoryWithDishesDTO> getCategoryWithDishes(@PathVariable Long id) {
        CategoryWithDishesDTO categoryWithDishes = categoryService.getCategoryWithDishes(id);
        return ResponseEntity.ok(categoryWithDishes);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategorie(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryWithDishesDTO> updateCategorie(@PathVariable Long id, @RequestBody CategoryWithDishesDTO dto){
        return ResponseEntity.ok(categoryService.update(id, dto));
    }


    public ResponseEntity<String> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok("Supprimé avec succes");
    }
}
