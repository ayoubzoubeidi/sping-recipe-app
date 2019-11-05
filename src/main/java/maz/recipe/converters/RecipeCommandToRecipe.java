package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.RecipeCommand;
import maz.recipe.domain.Category;
import maz.recipe.domain.Ingredient;
import maz.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null)
            return null;
        else {
            Recipe recipe = new Recipe();

            recipe.setId(source.getId());
            recipe.setDescription(source.getDescription());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setCookTime(source.getCookTime());
            recipe.setServings(source.getServings());
            recipe.setSource(source.getSource());
            recipe.setUrl(source.getUrl());
            recipe.setDirections(source.getDirections());
            recipe.setDifficulty(source.getDifficulty());

            Set<Ingredient> ingredients = new HashSet<>();
            source.getIngredients().forEach(ingredientCommand -> ingredients.add(ingredientConverter.convert(ingredientCommand)));
            recipe.setIngredients(ingredients);

            recipe.setNotes(notesConverter.convert(source.getNotes()));

            Set<Category> categories = new HashSet<>();
            source.getCategories().forEach(categoryCommand -> categories.add(categoryConverter.convert(categoryCommand)));
            recipe.setCategories(categories);

            return recipe;
        }
    }
}
