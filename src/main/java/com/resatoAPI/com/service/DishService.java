package com.resatoAPI.com.service;

import java.util.List;

public interface DishService {
    DishService save (DishService dto);
    DishService findById(Long id);
    List<DishService> getAll();
    DishService update(Long id, DishService dto);
    void deleteById(Long id);
}
