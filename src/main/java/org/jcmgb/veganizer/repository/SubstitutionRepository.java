package org.jcmgb.veganizer.repository;

import org.jcmgb.veganizer.entity.Substitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubstitutionRepository extends JpaRepository<Substitution, Long> {

    Substitution findByIngredient1(String ingredient1);

    Substitution findByIngredient2(String ingredient2);

}
