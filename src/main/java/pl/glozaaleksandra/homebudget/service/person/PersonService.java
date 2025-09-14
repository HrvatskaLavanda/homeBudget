package pl.glozaaleksandra.homebudget.service.person;

import lombok.AllArgsConstructor;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;
import pl.glozaaleksandra.homebudget.repository.PersonRepository;

import java.util.Optional;

@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public boolean personExistsByName(String personName) {
        Optional<PersonEntity> possiblyFoundPerson = personRepository.findByName(personName);
        return possiblyFoundPerson.isPresent();
    }

    public PersonEntity saveNewPerson(String personName) {
        return personRepository.findByName(personName)
                .orElseGet(() -> {
                    PersonEntity person = PersonEntity.builder()
                            .personName(personName)
                            .build();
                    return personRepository.save(person);
                });
    }

    public PersonEntity getByName(String personName) {
        return personRepository.findByName(personName)
                .orElseThrow(() -> new IllegalStateException("Person " + personName + " exists"));
    }
}

