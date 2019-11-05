package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.NotesCommand;
import maz.recipe.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null)
            return null;
        else {
            Notes notes = new Notes();
            notes.setId(source.getId());
            notes.setRecipeNotes(source.getRecipeNotes());
            return notes;
        }
    }
}
