package pl.glozaaleksandra.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
//    @Query(value = "select * from person where person_name = :personName", nativeQuery = true)
//    Optional<PersonEntity> findByPersonName(@Param("personName") String personName);

    Optional<PersonEntity> findByPersonId(int personId);

    @Query("from PersonEntity pe where pe.personName = :personName")
    Optional<PersonEntity> findByPersonName(@Param("personName") String personName);
}
