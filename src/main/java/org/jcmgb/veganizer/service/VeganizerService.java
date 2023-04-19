package org.jcmgb.veganizer.service;

import org.jcmgb.veganizer.exception.DuplicateValueException;
import org.jcmgb.veganizer.model.Recipe;
import org.jcmgb.veganizer.model.Substitution;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.jcmgb.veganizer.repository.SubstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeganizerService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    SubstitutionRepository substitutionRepository;

    public Recipe veganize(Recipe recipe) {
        if (! recipeRepository.findByTitle(recipe.getTitle()).isEmpty()) {
            throw new DuplicateValueException("A veganized recipe with that title already exists");
        }

        List<String> ingredientsList = List.of(recipe.getIngredients().split("\n"));
        String veganIngredientString = "";
        for (String ingredient : ingredientsList) {
            String[] ingredientArray = ingredient.split(" ");
            for (String sub : ingredientArray) {
                if (null != sub && sub.matches(".*\\d.*")){
                    veganIngredientString = veganIngredientString + sub + " ";
                    continue;
                }

                Substitution substitution = substitutionRepository.findByIngredient2ContainingAndCategory(sub, "any").isPresent() ?
                        substitutionRepository.findByIngredient2ContainingAndCategory(sub, "any").get() : null;

                if (null != substitution) {
                    veganIngredientString = veganIngredientString + substitution.getVegansub() + " ";
                } else {
                    veganIngredientString = veganIngredientString + sub + " ";
                }
            }

            // Replace the last " " with a "\n"
            if (veganIngredientString != null && veganIngredientString.length() > 0) {
                veganIngredientString = veganIngredientString.substring(0, veganIngredientString.length() - 1) + "\n";
            }
        }

        recipe.setVeganized(veganIngredientString);
        recipe.setCount(0);
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe getRecipeByTitle(String title) {
        Recipe recipe = new Recipe();

        if (recipeRepository.findByTitle(title).isEmpty()) {
            recipe.setTitle(recipe.getTitle() + " read from Db");
        } else {
            recipe = recipeRepository.findByTitle(title).get();
            recipe.setVeganized("new veganized content");
            recipe.setTitle(title);
            recipe.setCount(0);
            recipeRepository.save(recipe);
        }

        return recipe;
    }
}
