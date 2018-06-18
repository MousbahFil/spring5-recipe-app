package guru.springframework;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.NotesRepository;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication
public class Spring5RecipeAppApplication {

    public static final String TABLE_SPOON = "TableSpoon";

    public static void main(String[] args) {
		SpringApplication.run(Spring5RecipeAppApplication.class, args);
	}

	@Component
	public static  class MyBeanRunner implements CommandLineRunner{


		@Autowired
		private RecipeRepository recipesRepository;

		@Autowired
		private IngredientRepository ingredientRepository;

		@Autowired
		private CategoryRepository categoryRepository;

		@Autowired
		private NotesRepository notesRepository;

		@Override
		public void run(String... args) throws Exception {
			Recipe recipe=new Recipe();
			recipe.setDescription("Dummy Recipe");
			Ingredient ingredient=new Ingredient();
			ingredient.setAmount(new BigDecimal("10"));
			ingredient.setDescription("Dummy Ingredient");
			recipe.addIngredient(ingredient);
			Category category=new Category();
			category.setName("Dummy Category");
			recipe.addCategory(category);
			Notes notes=new Notes("Note");
			recipe.setNotes(notes);

			Recipe tacos=new Recipe();
			tacos.setDescription("Chili Tacos");
			tacos.setDifficulty(Difficulty.MEDIUM);
			Ingredient chiliPowder=new Ingredient();
			chiliPowder.setDescription("Chili Powder");
			chiliPowder.setAmount(new BigDecimal(2));
			chiliPowder.setUnitOfMeasure(new UnitOfMeasure(TABLE_SPOON));

			Ingredient ingredient2=new Ingredient();
			ingredient2.setDescription("Dried Oregano");
			ingredient2.setAmount(new BigDecimal(2));
			ingredient2.setUnitOfMeasure(new UnitOfMeasure(TABLE_SPOON));
			tacos.addIngredient(chiliPowder);
			tacos.addIngredient(ingredient2);


			recipesRepository.save(recipe);
            recipesRepository.save(tacos);
			Optional<Ingredient> ingredientOptional = ingredientRepository.findById(2L);
			System.out.println(ingredientOptional.get().getRecipe().getDescription());
			System.out.println(notesRepository.findByValue("Note").getRecipe().getDescription());
//			System.out.println(categoryRepository.findByName("Dummy Category").get().getRecipes().iterator().next().getDescription()); //Couldn't make this work

		}
	}
}
