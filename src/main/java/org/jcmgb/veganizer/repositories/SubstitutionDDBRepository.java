package org.jcmgb.veganizer.repositories;

import org.jcmgb.veganizer.model.SubstitutionDDB;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface SubstitutionDDBRepository extends CrudRepository<SubstitutionDDB, String> {
    Optional<SubstitutionDDB> findByIngredient2ContainingAndCategory(String ingredient2, String category);
    SubstitutionDDB findByIngredient1AndCategory(String ingredient1, String category);
    List<SubstitutionDDB> findAll();
}
