package pl.glozaaleksandra.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
