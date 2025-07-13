package pl.glozaaleksandra.homebudget.service.person;

import lombok.AllArgsConstructor;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.person.PersonRepository;

import java.util.Optional;

@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public boolean personExistsByName(String personName) {
        Optional<Person> possiblyFoundPerson = personRepository.getByName(personName);
        return possiblyFoundPerson.isPresent();
    }

    public Person saveNewPerson(String personName) {
        if (!personExistsByName(personName)) {
            Person newPerson = personRepository.addNewPerson(personName);
            return newPerson;
        }
    }

    public Person getByName(String personName) {
        // TODO fill in this method

    }
}
