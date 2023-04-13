package org.jcmgb.veganizer.repositories;

import org.jcmgb.veganizer.model.RecipeDDB;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface RecipeDDBRepository extends CrudRepository<RecipeDDB, String> {
    Optional<RecipeDDB> findByTitle(String title);

    List<RecipeDDB> findAll();
}
