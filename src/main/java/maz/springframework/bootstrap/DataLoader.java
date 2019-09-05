package maz.springframework.bootstrap;

import maz.springframework.domain.Difficulty;
import maz.springframework.domain.Ingredient;
import maz.springframework.domain.Recipe;
import maz.springframework.repositories.CategoryRepository;
import maz.springframework.repositories.RecipeRepository;
import maz.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        Ingredient ingredient3 = new Ingredient();
        Ingredient ingredient4 = new Ingredient();
        Ingredient ingredient5 = new Ingredient();
        Ingredient ingredient6 = new Ingredient();
        Ingredient ingredient7 = new Ingredient();
        Ingredient ingredient8 = new Ingredient();
        Set<Ingredient> ingredients = new HashSet<>();
        Recipe recipe = new Recipe();

        ingredient1.setDescription("avocados");
        ingredient1.setAmount(BigDecimal.valueOf(2));
        ingredient1.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("ripe").get());
        ingredient1.setRecipe(recipe);
        ingredients.add(ingredient1);

        ingredient2.setDescription("Kosher salt");
        ingredient2.setAmount(BigDecimal.valueOf(1/2));
        ingredient2.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("teaspoon").get());
        ingredient2.setRecipe(recipe);


        ingredients.add(ingredient2);

        ingredient3.setDescription("of fresh lime juice or lemon juice");
        ingredient3.setAmount(BigDecimal.valueOf(1));
        ingredient3.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("Tbsp").get());
        ingredient3.setRecipe(recipe);

        ingredients.add(ingredient3);

        ingredient4.setDescription("of minced red onion or thinly sliced green onion");
        ingredient4.setAmount(BigDecimal.valueOf(2));
        ingredient4.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("Tbsp").get());
        ingredient4.setRecipe(recipe);

        ingredients.add(ingredient4);

        ingredient5.setDescription("serrano chiles, stems and seeds removed, minced");
        ingredient5.setAmount(BigDecimal.valueOf(2));
        ingredient5.setRecipe(recipe);

        ingredients.add(ingredient5);

        ingredient6.setDescription("cilantro (leaves and tender stems), finely chopped");
        ingredient6.setAmount(BigDecimal.valueOf(2));
        ingredient6.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("Tbsp").get());
        ingredient6.setRecipe(recipe);

        ingredients.add(ingredient6);

        ingredient7.setDescription("Kosher salt");
        ingredient7.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("A dash").get());
        ingredient7.setRecipe(recipe);

        ingredients.add(ingredient7);

        ingredient8.setDescription("tomato, seeds and pulp removed, chopped");
        ingredient8.setUom(unitOfMeasureRepository.findUnitOfMeasureByUom("ripe").get());
        ingredient8.setAmount(BigDecimal.valueOf(1/2));
        ingredient8.setRecipe(recipe);

        ingredients.add(ingredient8);

        recipe.setCookTime(10);
        recipe.setDescription("ayoub");
        recipe.setDifficulty(Difficulty.Easy);
        recipe.setServings(4);
        recipe.setSource("simply recipes");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole");
        recipe.setIngredients(ingredients);
        recipeRepository.save(recipe);




    }
}
