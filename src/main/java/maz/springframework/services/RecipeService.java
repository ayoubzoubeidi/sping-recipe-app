package maz.springframework.services;

import maz.springframework.domain.Recipe;
import maz.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public Set<Recipe> findRecipes(){
        return (Set) recipeRepository.findAll();
    }

    public Recipe findRecipeByDescription(String description) {
        return recipeRepository.findRecipeByDescription(description).get();
    }


}
