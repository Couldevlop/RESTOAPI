package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        if(dto == null){

        }
        return null;
    }

    @Override
    public CategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return null;
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
