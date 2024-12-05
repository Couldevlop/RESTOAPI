package com.resatoAPI.com;

import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.CategoryRepository;
import com.resatoAPI.com.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestoApplication implements CommandLineRunner {
	private final CategoryService categoryService;
	private final  ObjectMapper objectMapper;
	private final CategoryRepository categoryRepository;

    public RestoApplication(CategoryService categoryService, ObjectMapper objectMapper, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.objectMapper = objectMapper;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(RestoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = Category.builder()
				.name("ENTREE")
				.dishes(null)
				.build();

		Category category1 = Category.builder()
				.name("RESISTANCE")
				.dishes(null)
				.build();

		Category category2 = Category.builder()
				.name("DESSERTS")
				.dishes(null)
				.build();

		Category category3 = Category.builder()
				.name("BOISSONS")
				.dishes(null)
				.build();

		categoryRepository.save(category);
		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);

	}

}
