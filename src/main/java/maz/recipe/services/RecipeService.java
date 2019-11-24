package maz.recipe.services;

import maz.recipe.commands.RecipeCommand;
import maz.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    void deleteById(Long id);
}
