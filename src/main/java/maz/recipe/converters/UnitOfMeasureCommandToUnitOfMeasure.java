package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.UnitOfMeasureCommand;
import maz.recipe.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null)
            return null;
        else {
            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(source.getId());
            unitOfMeasure.setDescription(source.getDescription());
            return unitOfMeasure;
        }
    }
}
