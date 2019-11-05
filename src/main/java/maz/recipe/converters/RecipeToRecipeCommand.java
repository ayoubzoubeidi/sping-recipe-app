package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.CategoryCommand;
import maz.recipe.commands.IngredientCommand;
import maz.recipe.commands.RecipeCommand;
import maz.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter, IngredientToIngredientCommand ingredientConverter, NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null)
            return null;
        else {
            RecipeCommand recipeCommand = new RecipeCommand();

            recipeCommand.setId(source.getId());
            recipeCommand.setDescription(source.getDescription());
            recipeCommand.setPrepTime(source.getPrepTime());
            recipeCommand.setCookTime(source.getCookTime());
            recipeCommand.setServings(source.getServings());
            recipeCommand.setSource(source.getSource());
            recipeCommand.setUrl(source.getUrl());
            recipeCommand.setDirections(source.getDirections());
            recipeCommand.setDifficulty(source.getDifficulty());

            Set<IngredientCommand> ingredientCommands = new HashSet<>();
            source.getIngredients().forEach(ingredient -> ingredientCommands.add(ingredientConverter.convert(ingredient)));
            recipeCommand.setIngredients(ingredientCommands);

            recipeCommand.setNotes(notesConverter.convert(source.getNotes()));

            Set<CategoryCommand> categoryCommands = new HashSet<>();
            source.getCategories().forEach(category -> categoryCommands.add(categoryConverter.convert(category)));
            recipeCommand.setCategories(categoryCommands);


            return recipeCommand;

        }
    }
}
