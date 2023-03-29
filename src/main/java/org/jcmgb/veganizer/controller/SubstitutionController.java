package org.jcmgb.veganizer.controller;

import org.jcmgb.veganizer.entity.Substitution;
import org.jcmgb.veganizer.repository.SubstitutionRepository;
import org.jcmgb.veganizer.service.VeganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubstitutionController {

    @Autowired
    VeganizerService veganizerService;

    @Autowired
    SubstitutionRepository substitutionRepository;

    @GetMapping("/substitutions")
    List<Substitution> getAllSubs() {
        return substitutionRepository.findAll();
    }

    @PostMapping("/substitution")
    public Substitution createSubtitution(@RequestBody Substitution substitution) {
        return substitutionRepository.save(substitution);
    }

    @GetMapping("/substitution")
    public Substitution getSubByIngredients(@RequestParam(name = "ingredient1") String ingredient1) {
        return substitutionRepository.findByIngredient1(ingredient1);
    }
}


