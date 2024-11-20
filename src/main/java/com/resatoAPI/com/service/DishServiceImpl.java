package com.resatoAPI.com.service;

import com.resatoAPI.com.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public DishService save(DishService dto) {
        return null;
    }

    @Override
    public DishService findById(Long id) {
        return null;
    }

    @Override
    public List<DishService> getAll() {
        return null;
    }

    @Override
    public DishService update(Long id, DishService dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
