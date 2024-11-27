package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.dto.CategoryWithDishesDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save (CategoryDTO dto);
    CategoryDTO findById(Long id);
    List<CategoryDTO> getAll();
    CategoryWithDishesDTO update(Long id, CategoryWithDishesDTO dto);
    CategoryWithDishesDTO getCategoryWithDishes(Long id);
    void deleteById(Long id);
}
