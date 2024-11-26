package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.DishDTO;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.exception.DishAlReadyException;
import com.resatoAPI.com.exception.DishNotFoundException;
import com.resatoAPI.com.exception.DishNullException;
import com.resatoAPI.com.repository.DishRepository;
import org.springframework.stereotype.Component;

@Component
public class DishValidator {
    private final DishRepository dishRepository;

    public DishValidator(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void validateDishDTO(DishDTO dto){
        if(dto == null){
            throw new DishNullException("The object provided is null: {}");
        }
    }

    public void validateId( Long id){
        if(id == null){
            throw new DishNullException("The ID provided is null");
        }
    }

    public void checkIfDishExists(String name){
        if(dishRepository.findByName(name)){
            throw new DishAlReadyException("Dish already exists in DB");
        }
    }

    public Dish findDishOrTgrow(Long id){
        return dishRepository.findById(id).orElseThrow(() ->
                new DishNotFoundException("Dish with ID " + id + " not found in DB"));
    }

    public void validateUpdateRequest(Long id, DishDTO dto){
        validateId(id);
        validateDishDTO(dto);
    }
}
