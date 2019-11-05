package maz.recipe.converters;

import maz.recipe.commands.NotesCommand;
import maz.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    private static final Long ID = new Long(1);
    private static final String NOTES = "notes";
    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void nullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convertTest() {

        //given
        Notes notes = new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(NOTES);

        //when
        NotesCommand convertedNotes = converter.convert(notes);

        //then
        assertNotNull(convertedNotes);
        assertEquals(ID, convertedNotes.getId());
        assertEquals(NOTES, convertedNotes.getRecipeNotes());

    }

}