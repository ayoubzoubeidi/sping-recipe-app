package maz.recipe.converters;

import maz.recipe.commands.CategoryCommand;
import maz.recipe.commands.IngredientCommand;
import maz.recipe.commands.NotesCommand;
import maz.recipe.commands.RecipeCommand;
import maz.recipe.domain.Difficulty;
import maz.recipe.domain.Notes;
import maz.recipe.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private static final Long ID = new Long(1);
    private static final String DESCRIPTION = "description";
    private static final Integer PREPTIME = 1;
    private static final Integer COOKTIME = 1;
    private static final Integer SERVINGS = 1;
    private static final String SOURCE = "source";
    private static final String URL = "url";
    private static final String DIRECTIONS = "directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Long NOTE_ID = new Long(2);
    private static final Long INGREDIENT_ID1 = new Long(1);
    private static final Long INGREDIENT_ID2 = new Long(2);
    private static final Long CATEGORY_ID1 = new Long(1);
    private static final Long CATEGORY_ID2 = new Long(2);
    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(
                new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void nullTest() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyTest() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convertTest()throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setCookTime(COOKTIME);
        recipeCommand.setPrepTime(PREPTIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand note = new NotesCommand();
        note.setId(NOTE_ID);
        recipeCommand.setNotes(note);

        IngredientCommand ing1 = new IngredientCommand();
        IngredientCommand ing2 = new IngredientCommand();
        ing1.setId(INGREDIENT_ID1);
        ing2.setId(INGREDIENT_ID2);
        recipeCommand.getIngredients().add(ing1);
        recipeCommand.getIngredients().add(ing2);

        CategoryCommand cat1 = new CategoryCommand();
        CategoryCommand cat2 = new CategoryCommand();
        cat1.setId(CATEGORY_ID1);
        cat2.setId(CATEGORY_ID2);
        recipeCommand.getCategories().add(cat1);
        recipeCommand.getCategories().add(cat2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        //then
        assertNotNull(recipe);

        assertEquals(ID, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(COOKTIME, recipe.getCookTime());
        assertEquals(PREPTIME, recipe.getPrepTime());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTE_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getIngredients().size());
        assertEquals(2, recipe.getCategories().size());
    }
}