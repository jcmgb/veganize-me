package org.jcmgb.veganizer.controller;

import org.jcmgb.veganizer.model.RecipeDDB;
import org.jcmgb.veganizer.repositories.RecipeDDBRepository;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.jcmgb.veganizer.service.VeganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecipeController {

    @Autowired
    VeganizerService veganizerService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDDBRepository recipeDDBRepository;

    @GetMapping("/recipes")
    List<RecipeDDB> getAllRecipes() {
        return recipeDDBRepository.findAll();
    }

    @PostMapping("/veganize")
    public RecipeDDB veganize(@RequestBody RecipeDDB recipe) {
        return veganizerService.veganize(recipe);
    }

    @GetMapping("/recipe")
    public RecipeDDB getRecipeByTitle(@RequestParam(required = true, name = "title") String title) {
        return veganizerService.getRecipeByTitle(title);
    }
}


