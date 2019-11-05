package maz.recipe.converters;

import maz.recipe.commands.IngredientCommand;
import maz.recipe.domain.Ingredient;
import maz.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    private static final Long ID = new Long(1);
    private static final String  DESCRIPTION = "description";
    private static final BigDecimal AMOUNT = new BigDecimal(1);
    private static final Long UOM_ID = new Long(1);
    IngredientToIngredientCommand converter;


    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void nullTest() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyTest() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convertTest()throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertNotNull(ingredientCommand);
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());

    }
}