package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.exception.CategorieNullException;
import com.resatoAPI.com.exception.CategoryAlReadyExistException;
import com.resatoAPI.com.exception.CategoryNotFoundException;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ObjectMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ObjectMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        if(dto == null){
            throw new CategorieNullException("The objet you are given is nul:{}");
        }
        if(categoryRepository.finByName(dto.getName())){
            throw new CategoryAlReadyExistException("Category is already exists in DB");
        }
        Category category = categoryRepository.save(mapper.dtoToCategory(dto));
        return mapper.categoryToDTO(category) ;
    }

    @Override
    public CategoryDTO findById(Long id) {
        if(id == null){
            throw new CategorieNullException("The id you are given is nul:{}");
        }
     Category category = categoryRepository.findById(id).orElseThrow(()->
             new CategoryNotFoundException("Element is not present")
        );
        return mapper.categoryToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(mapper::categoryToDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        if(id == null){
            throw new CategorieNullException("The id you are given is nul:{}");
        }
        if(dto == null){
            throw new CategorieNullException("The objet you are given is nul:{}");
        }
        Category category = categoryRepository.findById(id).orElseThrow(()->
                new CategoryNotFoundException(" The categorie with id egal " + id + "could not befound in DB"));
        dto.setId(category.getId());
        Category categorySaved = categoryRepository.save(mapper.dtoToCategory(dto));
        return mapper.categoryToDTO(categorySaved);
    }

    @Override
    public void deleteById(Long id) {

    }
}
