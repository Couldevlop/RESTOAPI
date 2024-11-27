package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.dto.CategoryWithDishesDTO;
import com.resatoAPI.com.dto.DishDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.exception.CategorieNullException;
import com.resatoAPI.com.exception.CategoryNotFoundException;
import com.resatoAPI.com.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(categoryRepository.existsByName(name)){
            throw new CategoryNotFoundException("Category already exists in DB " );
        }
    }

    public void validateUpdateRequest(Long id, CategoryDTO dto){
        validateId(id);
        ValidateCategoryDTO(dto);
    }

    public void validateUpdateRequestWithDish(Long id, CategoryWithDishesDTO dto) {
        // 1. Vérifier que l'ID de la catégorie n'est pas null
        if (id == null) {
            throw new IllegalArgumentException("Category ID must not be null");
        }

        // 2. Vérifier que la catégorie existe dans la base de données
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category with ID " + id + " not found");
        }

        // 3. Validation du nom de la catégorie
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name must not be null or empty");
        }

        // 4. Validation des Dishes (si présents)
        if (dto.getDishes() != null) {
            for (DishDTO dish : dto.getDishes()) {
                // Vérifier que le nom du plat n'est pas null ou vide
                if (dish.getName() == null || dish.getName().trim().isEmpty()) {
                    throw new IllegalArgumentException("Dish name must not be null or empty");
                }

                // Vérifier que le prix est valide
                if (dish.getPrice() < 0) {
                    throw new IllegalArgumentException("Dish price must be greater than or equal to 0");
                }

                // Vérifier que le categoryId correspond à l'ID de la catégorie
                if (dish.getCategoryId() != null && !dish.getCategoryId().equals(id)) {
                    throw new IllegalArgumentException(
                            "Dish categoryId (" + dish.getCategoryId() + ") does not match the Category ID (" + id + ")"
                    );
                }
            }
        }
    }



}
