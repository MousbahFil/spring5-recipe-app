package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() throws Exception{
        log.info("---Project Lombok --- Recipes service is invoking find all on recipes recipes repository");
        Iterable<Recipe> iterator = recipeRepository.findAll();
        List<Recipe> recipes=new ArrayList<>();
        iterator.forEach(recipes::add);
        return recipes;
    }
}
