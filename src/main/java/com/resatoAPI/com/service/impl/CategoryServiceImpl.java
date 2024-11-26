package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.entity.Category;
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

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(mapper::categoryToDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        categoryValidator.validateUpdateRequest(id, dto);
        Category existingCategory = categoryValidator.findCategoryOrThrow(id);
       existingCategory.setName(dto.getName());

       if(dto.getDishes() != null){
           existingCategory.setDishes(dto.getDishes().stream().map(mapper::dtoToDish).collect(Collectors.toList()));
       }


        Category updateCategory = categoryRepository.save(existingCategory);
        return mapper.categoryToDTO(updateCategory);
    }

    @Override
    public void deleteById(Long id) {
        categoryValidator.validateId(id);
        categoryValidator.findCategoryOrThrow(id);
        categoryRepository.deleteById(id);
    }
}
