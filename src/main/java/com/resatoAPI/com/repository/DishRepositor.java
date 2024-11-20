package com.resatoAPI.com.repository;

import com.resatoAPI.com.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepositor extends JpaRepository<Dish, Long> {
}
