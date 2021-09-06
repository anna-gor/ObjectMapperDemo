package com.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.domain.Ingredient;
import com.mapper.domain.Recipe;
import com.mapper.repo.IngredientRepo;
import com.mapper.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ObjectMapperDemoApplication implements CommandLineRunner {
	@Autowired
	private IngredientRepo ingredientRepo;

	@Autowired
	private RecipeRepo recipeRepo;


	public static void main(String[] args) {
		SpringApplication.run(ObjectMapperDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ingredientRepo.deleteAllInBatch();
		recipeRepo.deleteAllInBatch();
		final ObjectMapper objectMapper = new ObjectMapper();
       Recipe[] lags = objectMapper.readValue(new File("src/main/resources/test.json"), Recipe[].class);

		for (Recipe s : lags) {

            for (Ingredient ing: s.getIngredients()){
                ing.getRecipes().add(s);
            }
            for (Ingredient ing: s.getIngredients()){
                s.getIngredients().add(ing);
            }
			recipeRepo.save(s);
            }

	}
}
