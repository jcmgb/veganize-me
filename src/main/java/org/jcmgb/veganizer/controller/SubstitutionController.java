package org.jcmgb.veganizer.controller;

import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import org.jcmgb.veganizer.exception.DuplicateValueException;
import org.jcmgb.veganizer.model.SubstitutionDDB;
import org.jcmgb.veganizer.repositories.SubstitutionDDBRepository;
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

    @Autowired
    SubstitutionDDBRepository substitutionDDBRepository;

    @GetMapping("/substitutions")
    List<SubstitutionDDB> getAllSubs() {
        return substitutionDDBRepository.findAll();
    }

    @PostMapping("/substitution")
    public SubstitutionDDB createSubtitution(@RequestBody SubstitutionDDB substitution) {
        try {
            substitution = substitutionDDBRepository.save(substitution);
        } catch (ConditionalCheckFailedException e) {
            throw new DuplicateValueException("A vegan sub for that ingredient and category already exists");
        }

        return substitution;
    }

//    @GetMapping("/substitution")
//    public SubstitutionDDB getSubByIngredients(@RequestParam(name = "ingredient1") String ingredient1) {
//        return substitutionDDBRepository.findByIngredient1(ingredient1).get();
//    }
}


