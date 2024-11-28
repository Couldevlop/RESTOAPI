package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.DishDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.DishRepository;
import com.resatoAPI.com.service.DishService;
import com.resatoAPI.com.validators.CategoryValidator;
import com.resatoAPI.com.validators.DishValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final ObjectMapper mapper;
    private final DishValidator dishValidator;
    private final CategoryValidator categoryValidator;

    public DishServiceImpl(DishRepository dishRepository, ObjectMapper mapper, DishValidator dishValidator, CategoryValidator categoryValidator) {
        this.dishRepository = dishRepository;
        this.mapper = mapper;
        this.dishValidator = dishValidator;
        this.categoryValidator = categoryValidator;
    }

    @Override
    public DishDTO save(DishDTO dto) {
        dishValidator.validateDishDTO(dto);
        dishValidator.checkIfDishExists(dto.getName());
        Dish dish = mapper.dtoToDish(dto);
        Dish dishSaved = dishRepository.save(dish);
        return mapper.dishToDTO(dishSaved);
    }

    @Override
    public DishDTO findById(Long id) {
        dishValidator.validateId(id);
        Dish existingDish = dishValidator.findDishOrTgrow(id);
        return mapper.dishToDTO(existingDish);
    }

    @Override
    public List<DishDTO> getAll() {
        return dishRepository.findAll().stream().map(mapper::dishToDTO).collect(Collectors.toList());
    }

    @Override
    public DishDTO update(Long id, DishDTO dto) {
        dishValidator.validateUpdateRequest(id, dto);
        Dish existingDish = dishValidator.findDishOrTgrow(id);
        existingDish.setName(dto.getName());
        existingDish.setImage(dto.getImage());
        existingDish.setPrice(dto.getPrice());
        existingDish.setIngredients(dto.getIngredients());
        Category category = categoryValidator.findCategoryOrThrow(dto.getId());
        existingDish.setCategory(category);
        Dish disSaved = dishRepository.save(existingDish);
        return mapper.dishToDTO(disSaved);
    }

    @Override
    public void deleteById(Long id) {
        dishValidator.validateId(id);
       dishValidator.findDishOrTgrow(id);
        dishRepository.deleteById(id);
    }
}
