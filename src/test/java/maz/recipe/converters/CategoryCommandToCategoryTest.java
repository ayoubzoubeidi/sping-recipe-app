package maz.recipe.converters;

import maz.recipe.commands.CategoryCommand;
import maz.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private static final Long ID = new Long(1);
    private static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void nullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void EmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));

    }

    @Test
    public void convertTest() throws Exception {

        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category convertedCategory = converter.convert(categoryCommand);

        //then
        assertNotNull(convertedCategory);
        assertEquals(ID, convertedCategory.getId());
        assertEquals(DESCRIPTION, convertedCategory.getDescription());


    }
}