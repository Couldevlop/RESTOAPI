package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save (CategoryDTO dto);
    CategoryDTO findById(Long id);
    List<CategoryDTO> getAll();
    CategoryDTO update(Long id, CategoryDTO dto);
    void deleteById(Long id);
}
