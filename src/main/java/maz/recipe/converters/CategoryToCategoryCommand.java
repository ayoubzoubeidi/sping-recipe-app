package maz.recipe.converters;

import lombok.Synchronized;
import maz.recipe.commands.CategoryCommand;
import maz.recipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null)
            return null;
        else {
            final CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(source.getId());
            categoryCommand.setDescription(source.getDescription());
            return categoryCommand;
        }

    }
}
