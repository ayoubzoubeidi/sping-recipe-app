package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.UnitOfMeasureCommand;
import maz.recipe.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null)
            return null;
         else {
             UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
             unitOfMeasureCommand.setId(source.getId());
             unitOfMeasureCommand.setDescription(source.getDescription());
             return unitOfMeasureCommand;
        }
    }
}
