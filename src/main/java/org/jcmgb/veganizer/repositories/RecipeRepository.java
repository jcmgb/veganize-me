package org.jcmgb.veganizer.repositories;

import org.jcmgb.veganizer.model.Recipe;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface RecipeRepository extends CrudRepository<Recipe, String> {
    Optional<Recipe> findByTitle(String title);

    List<Recipe> findAll();
}
