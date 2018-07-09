package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController("/api")
public class RecipesCrudController {

    private RecipeService recipeService;

    public RecipesCrudController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public Set<Recipe> getRecipes(){
        return recipeService.getRecipes();
    }

    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Recipe getRecipe(@PathVariable("id") Long id){
        return recipeService.findById(id);
    }

    @PostMapping("/recipes")
    public void createRecipe(@RequestBody  Recipe recipe){
        recipeService.saveRecipe(recipe);
    }


}
