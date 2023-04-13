package org.jcmgb.veganizer.repositories;

import org.jcmgb.veganizer.model.Substitution;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface SubstitutionRepository extends CrudRepository<Substitution, String> {
    Optional<Substitution> findByIngredient2ContainingAndCategory(String ingredient2, String category);
    Substitution findByIngredient1AndCategory(String ingredient1, String category);
    List<Substitution> findAll();
}
