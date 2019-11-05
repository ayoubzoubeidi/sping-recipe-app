package maz.recipe.converters;

import maz.recipe.commands.CategoryCommand;
import maz.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private static final Long ID = new Long(1) ;
    private static final String DESCRIPTION = "Sweet";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void nullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convertTest() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertNotNull(categoryCommand);
        assertEquals(ID, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}