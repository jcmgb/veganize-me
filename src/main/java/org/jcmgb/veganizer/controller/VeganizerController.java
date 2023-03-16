package org.jcmgb.veganizer.controller;

import org.jcmgb.veganizer.entity.Recipe;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.jcmgb.veganizer.service.VeganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeganizerController {

    @Autowired
    VeganizerService veganizerService;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @GetMapping("/veganize")
    public Recipe veganize() {
        return veganizerService.veganize("recipe content");
    }

    @GetMapping("/recipe")
    public Recipe getRecipeByTitle(@RequestParam(required = true, name = "title") String title) {
        return veganizerService.getRecipeByTitle(title);
    }
}


