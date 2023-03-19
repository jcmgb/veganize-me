package org.jcmgb.veganizer.service;

import org.jcmgb.veganizer.entity.Recipe;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeganizerService {

    @Autowired
    RecipeRepository recipeRepository;

    public Recipe veganize(Recipe recipe) {
        recipe.setVeganized("vegan content");
        recipe.setCount(0);

        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe getRecipeByTitle(String title) {
        Recipe recipe;
        recipe = recipeRepository.findByTitle(title);

        if (null != recipe) {
            recipe.setTitle(recipe.getTitle() + " read from Db");
        } else {
            recipe = new Recipe();
            recipe.setVeganized("new veganized content");
            recipe.setTitle(title);
            recipe.setCount(0);
            recipeRepository.save(recipe);
        }

        return recipe;
    }
}
