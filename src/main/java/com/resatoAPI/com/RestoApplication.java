package com.resatoAPI.com;

import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.CategoryRepository;
import com.resatoAPI.com.repository.DishRepository;
import com.resatoAPI.com.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestoApplication implements CommandLineRunner {
	private final  ObjectMapper objectMapper;
	private final CategoryRepository categoryRepository;
	private final DishRepository dishRepository;

    public RestoApplication(ObjectMapper objectMapper, CategoryRepository categoryRepository, DishRepository dishRepository) {
        this.objectMapper = objectMapper;
        this.categoryRepository = categoryRepository;
        this.dishRepository = dishRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(RestoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		if(categoryRepository.findAll().isEmpty()){

			//---------- AJOUT DE CATEGORIE ------------//
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

			//------------ AJOUT DE PLATS ----------//
			Dish dish1 = Dish.builder()
					.category(category)
					.description("Une recette facile à improviser pour un repas entre copains ou un dîner en solo qui combine les saveurs épicées, salées et sucrées.")
					.price(1500)
					.name("Halloumi au four")
					.ingredients("250 g d'halloumi, 2 cuillère(s) à soupe de harissa (à la rose), 2 cuillère(s) à soupe de miel (clair), le jus d'1 citron vert")
					.image("https://resize.elle.fr/portrait_320_webp/var/plain_site/storage/images/elle-a-table/recettes-de-cuisine/halloumi-au-four-3887522/93957230-1-fre-FR/Halloumi-au-four.jpg")
					.build();

			Dish dish11 = Dish.builder()
					.category(category)
					.description("Pour donner un air de vacances, ajoutez quelques gouttes d’ouzo.")
					.price(1200)
					.image("https://resize.elle.fr/portrait_320_webp/var/plain_site/storage/images/elle-a-table/recettes-de-cuisine/tzatziki-929182/12054768-7-fre-FR/Tzatziki.jpg")
					.name("Tzatziki")
					.ingredients("1 botte d’aneth, 1 botte de menthe,2 concombres, 1 kg de yaourt grec, 2 gousses d'ail, Le jus de 3 citrons jaunes, huile d'olive, Sel fin, poivre du moulin")
					.build();

			Dish dish12 = Dish.builder()
					.category(category)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(2500)
					.image("https://d165zz1olxm90a.cloudfront.net/eyJidWNrZXQiOiJhZGMtcHJvZC1pbWFnZXMtcmVjaXBlcyIsImtleSI6Ijd5M3ZwMXIwbzFpa3A3eG1wYWU1LmpwZyIsImVkaXRzIjp7ImpwZWciOnsicXVhbGl0eSI6ODB9LCJwbmciOnsicXVhbGl0eSI6ODB9LCJ3ZWJwIjp7InF1YWxpdHkiOjgwfX19")
					.name("Potage tomate")
					.ingredients("Tomate(s) 10 pièces, Piment(s) rouge(s) 1 pièce,Oignon(s) 1 pièce, Gousse(s) d'ail 6 pèces, Branche(s) de thym 4 pièces, Huile d'olive, huile d'olive, Bouillon de légumes")
					.build();

			Dish dish13 = Dish.builder()
					.category(category)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(2500)
					.image("./images/ENTREE4.jpeg")
					.name("Tatin de raclette")
					.ingredients("Raclette au lait cru, Rouleau(x) de pâte brisée, Pomme(s) de terre à chair ferme, Tranche(s) de lard fumé,Crème fraîche épaisse, Echalote(s)")
					.build();

//---------------------------------------------RESISTANCE---------------------------------------------------------------------//
			Dish dish2 = Dish.builder()
					.category(category1)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(5000)
					.image("./images/RESISTANCE1.jpeg")
					.name("Foutou Banane")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish21 = Dish.builder()
					.category(category1)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(5500)
					.image("./images/RESISTANCE2.jpeg")
					.name("Kabato")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish22 = Dish.builder()
					.category(category1)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(5000)
					.image("./images/RESISTANCE3.jpeg")
					.name("Gouagouassou")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish23 = Dish.builder()
					.category(category1)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(4000)
					.image("./images/RESISTANCE3.jpeg")
					.name("Attiéké Garba")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

//-------------------------------BOISSON------------------------------------------------------//
			Dish dish3 = Dish.builder()
					.category(category3)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(7000)
					.image("./images/BOISSON1.jpeg")
					.name("Vodka")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish31 = Dish.builder()
					.category(category3)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(8000)
					.image("./images/BOISSON2.jpeg")
					.name("Vin Rouge")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish32 = Dish.builder()
					.category(category3)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(1000)
					.image("./images/BOISSON3.jpeg")
					.name("Koutoukou")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();
			Dish dish33 = Dish.builder()
					.category(category3)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(9000)
					.image("./images/BOISSON4.jpeg")
					.name("Wisky")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			//--------------------------- DESSERTS-------------------//


			Dish dish4 = Dish.builder()
					.category(category2)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(1000)
					.image("./images/DESSERT1.jpeg")
					.name("Sucrerie")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish41 = Dish.builder()
					.category(category2)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(2000)
					.image("./images/DESSERT2.jpeg")
					.name("Chocolat")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish42 = Dish.builder()
					.category(category2)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(3000)
					.image("./images/DESSERT3.jpeg")
					.name("Thé Chinois")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();

			Dish dish43 = Dish.builder()
					.category(category2)
					.description("Un véritable délice naturel. C'est un plat qui vous dispose à bien apprécier vos plats de résistances")
					.price(1500)
					.image("./images/DESSERT4.jpeg")
					.name("Café au lait")
					.ingredients("Banane, gombo, poisson fumé, Patte de de boeuf, huille rouge, Tranche(s) de lard fumé, Echalote(s)")
					.build();


			List<Dish> dishList = new ArrayList<>();
			dishList.add(dish1);
			dishList.add(dish12);
			dishList.add(dish13);
			dishList.add(dish2);
			dishList.add(dish21);
			dishList.add(dish22);
			dishList.add(dish23);
			dishList.add(dish3);
			dishList.add(dish31);
			dishList.add(dish32);
			dishList.add(dish33);
			dishList.add(dish4);
			dishList.add(dish41);
			dishList.add(dish42);
			dishList.add(dish43);

			for(Dish d : dishList){
				dishRepository.save(d);
			}


			categoryRepository.save(category);
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
		}


	}

}
