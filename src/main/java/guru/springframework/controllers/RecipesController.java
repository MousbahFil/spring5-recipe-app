package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RecipesController {

    @GetMapping("/recipes")
    public List<Recipe> getRecipes(){
        return Collections.emptyList();
    }
}
