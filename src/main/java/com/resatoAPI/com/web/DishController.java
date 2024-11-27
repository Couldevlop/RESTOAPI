package com.resatoAPI.com.web;

import com.resatoAPI.com.dto.DishDTO;
import com.resatoAPI.com.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resto/api/dishes")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }


    @PostMapping
    public ResponseEntity<DishDTO> save(@RequestBody DishDTO dto){
        return ResponseEntity.ok(dishService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<DishDTO>> getAll(){
        return ResponseEntity.ok(dishService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishDTO> getById(@PathVariable Long id, @RequestBody DishDTO dto){
        return ResponseEntity.ok(dishService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        dishService.deleteById(id);
        return ResponseEntity.ok("Supprimé avec succès");
    }
}
