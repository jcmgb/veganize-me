package org.jcmgb.veganizer.controller;

import org.jcmgb.veganizer.entity.Recipe;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.jcmgb.veganizer.service.VeganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://veganizeme-angular-app.s3-website-us-east-1.amazonaws.com",
        "http://localhost:4200"
})

//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeganizerController {

    @Autowired
    VeganizerService veganizerService;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping("/veganize")
    public Recipe veganize(@RequestBody Recipe recipe) {
        return veganizerService.veganize(recipe);
    }

    @GetMapping("/recipe")
    public Recipe getRecipeByTitle(@RequestParam(required = true, name = "title") String title) {
        return veganizerService.getRecipeByTitle(title);
    }
}


