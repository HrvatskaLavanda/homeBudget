package pl.glozaaleksandra.homebudget.service.person;

import lombok.AllArgsConstructor;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.person.PersonRepository;

@AllArgsConstructor
public class PersonService {
  private PersonRepository personRepository;

  public boolean personExistsByName(String personName) {
   // TODO fill in this method
  }

  public Person saveNewPerson(String personName) {
    // TODO fill in this method

  }

  public Person getByName(String personName) {
    // TODO fill in this method

  }
}
