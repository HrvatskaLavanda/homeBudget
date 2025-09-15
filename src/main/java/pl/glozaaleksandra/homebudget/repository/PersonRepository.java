package pl.glozaaleksandra.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    Optional<PersonEntity> findByPersonName(String personName);
}
