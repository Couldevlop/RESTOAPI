package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.exception.CategorieNullException;
import com.resatoAPI.com.exception.CategoryNotFoundException;
import com.resatoAPI.com.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
    private final CategoryRepository categoryRepository;

    public CategoryValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void ValidateCategoryDTO( CategoryDTO dto){
        if( dto == null){
            throw new CategorieNullException("The object provided is null : {}");
        }
    }

    public void validateId(Long id){
        if(id == null){
            throw new CategorieNullException("This ID provided is null");
        }
    }

    public Category findCategoryOrThrow(Long id){
        return categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException("Category with id " + id + " not found in DB"));
    }

    public void checkIfCategoryExists(String name){
        if(categoryRepository.findByName(name)){
            throw new CategoryNotFoundException("Category already exists in DB " );
        }
    }

    public void validateUpdateRequest(Long id, CategoryDTO dto){
        validateId(id);
        ValidateCategoryDTO(dto);
    }



}
