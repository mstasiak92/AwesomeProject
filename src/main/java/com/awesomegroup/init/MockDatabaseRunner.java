package com.awesomegroup.init;

import com.awesomegroup.ingredients.Ingredient;
import com.awesomegroup.ingredients.IngredientMeasurement;
import com.awesomegroup.recipe.Recipe;
import com.awesomegroup.recipe.RecipeDifficulty;
import com.awesomegroup.recipeingredient.RecipeIngredient;
import com.awesomegroup.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Michał on 2017-04-17.
 */
@Component
public class MockDatabaseRunner implements ApplicationRunner {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Ingredient ingredient = Ingredient.create()
                                            .id(1L)
                                            .availableMeasurements(IngredientMeasurement.ML, IngredientMeasurement.L)
                                            .name("milk")
                                            .build();

        Recipe recipe = Recipe.create()
                                .id(1)
                                .name("Recipe name")
                                .preparationTime((short) 25)
                                .difficulty(RecipeDifficulty.EASY)
                                .servings((byte) 1)
                                .ingredients()
                                .build();

        RecipeIngredient recipeIngredient = RecipeIngredient.create()
                .recipe(recipe)
                .ingredient(ingredient)
                .measurement(IngredientMeasurement.ML)
                .count(200).build();

        recipeRepository.save(recipe);

    }
}
