package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.DishDTO;

import java.util.List;

public interface DishService {
    DishDTO save (DishDTO dto);
    DishDTO findById(Long id);
    List<DishDTO> getAll();
    DishDTO update(Long id, DishDTO dto);
    void deleteById(Long id);
}
