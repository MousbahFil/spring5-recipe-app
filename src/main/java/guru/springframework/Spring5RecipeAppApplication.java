package guru.springframework;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.IngredientsRepository;
import guru.springframework.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@SpringBootApplication
public class Spring5RecipeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5RecipeAppApplication.class, args);
	}

	@Component
	public static  class MyBeanRunner implements CommandLineRunner{


		@Autowired
		private RecipesRepository recipesRepository;

		@Override
		public void run(String... args) throws Exception {
			Recipe recipe=new Recipe();
			recipe.setDescription("Dummy Recipe 1");
			Ingredient ingredient=new Ingredient();
			ingredient.setAmount(new BigDecimal("12"));
			ingredient.setDescription("Dummy ingredient");
			recipe.getIngredients().add(ingredient);
			recipesRepository.save(recipe);

		}
	}
}
