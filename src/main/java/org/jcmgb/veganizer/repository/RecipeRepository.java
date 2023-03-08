package org.jcmgb.veganizer.repository;

import org.jcmgb.veganizer.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByTitle(String title);
}
