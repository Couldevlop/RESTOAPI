package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.dto.CategoryWithDishesDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.CategoryRepository;
import com.resatoAPI.com.service.CategoryService;
import com.resatoAPI.com.validators.CategoryValidator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ObjectMapper mapper;
    private final CategoryValidator categoryValidator;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ObjectMapper mapper, CategoryValidator categoryValidator) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.categoryValidator = categoryValidator;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        categoryValidator.ValidateCategoryDTO(categoryDTO);
        categoryValidator.checkIfCategoryExists(categoryDTO.getName());
        Category category = mapper.dtoToCategory(categoryDTO);
        Category categorySaved = categoryRepository.save(category);
        return mapper.categoryToDTO(categorySaved) ;
    }

    @Override
    public CategoryDTO findById(Long id) {
       categoryValidator.validateId(id);
     Category category = categoryValidator.findCategoryOrThrow(id);
        return mapper.categoryToDTO(category);
    }

    public CategoryWithDishesDTO getCategoryWithDishes(Long id){
        Category category = categoryValidator.findCategoryOrThrow(id);
        return mapper.categoryToWithDishesDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(mapper::categoryToDTO).collect(Collectors.toList());
    }



    @Override
    public CategoryWithDishesDTO update(Long id, CategoryWithDishesDTO dto) {
        // 1. Validation des données d'entrée
        categoryValidator.validateUpdateRequestWithDish(id, dto);

        // 2. Récupérer la catégorie existante
        Category existingCategory = categoryValidator.findCategoryOrThrow(id);

        // 3. Mise à jour des champs simples de la catégorie
        existingCategory.setName(dto.getName());


        // 4. Gestion des Dishes associés
        if (dto.getDishes() != null) {
            // Nettoyer les `Dishes` existants (JPA gère les suppressions grâce à orphanRemoval)
            existingCategory.getDishes().clear();

            // Ajouter ou mettre à jour les nouveaux `Dishes`
            dto.getDishes().forEach(dishDTO -> {
                Dish dish = mapper.dtoToDish(dishDTO);
                dish.setCategory(existingCategory); // Lier chaque Dish à la Category
                existingCategory.getDishes().add(dish);
            });
        }

        // 5. Enregistrer les modifications
        Category updatedCategory = categoryRepository.save(existingCategory);

        // 6. Retourner un DTO enrichi avec les Dishes mis à jour
        return mapper.categoryToWithDishesDTO(updatedCategory);
    }



    @Override
    public void deleteById(Long id) {
        categoryValidator.validateId(id);
        categoryValidator.findCategoryOrThrow(id);
        categoryRepository.deleteById(id);
    }
}
