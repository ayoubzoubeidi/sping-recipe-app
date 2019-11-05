package maz.recipe.converters;

import maz.recipe.commands.UnitOfMeasureCommand;
import maz.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final Long ID = new Long(1);
    private static final String DESCRIPTION = "description";
    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void nullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convertTest() {

        //given
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(ID);
        uomCommand.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure convertedUom = converter.convert(uomCommand);

        //then
        assertNotNull(convertedUom);
        assertEquals(ID, convertedUom.getId());
        assertEquals(DESCRIPTION, convertedUom.getDescription());

    }


}