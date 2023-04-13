package org.jcmgb.veganizer.service;

import org.jcmgb.veganizer.exception.DuplicateValueException;
import org.jcmgb.veganizer.model.RecipeDDB;
import org.jcmgb.veganizer.model.SubstitutionDDB;
import org.jcmgb.veganizer.repositories.RecipeDDBRepository;
import org.jcmgb.veganizer.repositories.SubstitutionDDBRepository;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeganizerService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    SubstitutionDDBRepository substitutionDDBRepository;

    @Autowired
    RecipeDDBRepository recipeDDBRepository;

    public RecipeDDB veganize(RecipeDDB recipe) {
        if (! recipeDDBRepository.findByTitle(recipe.getTitle()).isEmpty()) {
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

                SubstitutionDDB substitution = substitutionDDBRepository.findByIngredient2ContainingAndCategory(sub, "any").isPresent() ?
                        substitutionDDBRepository.findByIngredient2ContainingAndCategory(sub, "any").get() : null;

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
        recipeDDBRepository.save(recipe);
        return recipe;
    }

    public RecipeDDB getRecipeByTitle(String title) {
        RecipeDDB recipe = new RecipeDDB();

        if (recipeDDBRepository.findByTitle(title).isEmpty()) {
            recipe.setTitle(recipe.getTitle() + " read from Db");
        } else {
            recipe = recipeDDBRepository.findByTitle(title).get();
            recipe.setVeganized("new veganized content");
            recipe.setTitle(title);
            recipe.setCount(0);
            recipeDDBRepository.save(recipe);
        }

        return recipe;
    }
}
