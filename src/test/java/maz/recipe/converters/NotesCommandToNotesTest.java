package maz.recipe.converters;

import maz.recipe.commands.NotesCommand;
import maz.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    private static final Long ID = new Long(1);
    private static final String NOTES = "notes";
    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void nullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convertTest() {

        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(NOTES);

        //when
        Notes convertedNotes = converter.convert(notesCommand);

        //then
        assertNotNull(convertedNotes);
        assertEquals(ID, convertedNotes.getId());
        assertEquals(NOTES, convertedNotes.getRecipeNotes());

    }


}