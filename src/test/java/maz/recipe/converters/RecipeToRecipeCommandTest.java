package maz.recipe.converters;

import maz.recipe.commands.RecipeCommand;
import maz.recipe.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {

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
    RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeCommand(
                new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    @Test
    public void nullTest() throws Exception {
        assertNull(converter.convert(null));

    }

    @Test
    public void emptyTest() throws Exception {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    public void convertTest()throws Exception {

        //given
        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setCookTime(COOKTIME);
        recipe.setPrepTime(PREPTIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Notes note = new Notes();
        note.setId(NOTE_ID);
        recipe.setNotes(note);

        Ingredient ing1 = new Ingredient();
        Ingredient ing2 = new Ingredient();
        ing1.setId(INGREDIENT_ID1);
        ing2.setId(INGREDIENT_ID2);
        recipe.getIngredients().add(ing1);
        recipe.getIngredients().add(ing2);

        Category cat1 = new Category();
        Category cat2 = new Category();
        cat1.setId(CATEGORY_ID1);
        cat2.setId(CATEGORY_ID2);
        recipe.getCategories().add(cat1);
        recipe.getCategories().add(cat2);

        //when
        RecipeCommand recipeCommand = converter.convert(recipe);

        //then
        assertNotNull(recipeCommand);

        assertEquals(ID, recipeCommand.getId());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(COOKTIME, recipeCommand.getCookTime());
        assertEquals(PREPTIME, recipeCommand.getPrepTime());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(NOTE_ID, recipeCommand.getNotes().getId());
        assertEquals(2, recipeCommand.getIngredients().size());
        assertEquals(2, recipeCommand.getCategories().size());
    }
}