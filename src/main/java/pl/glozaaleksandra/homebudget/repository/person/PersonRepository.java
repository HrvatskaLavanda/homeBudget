package pl.glozaaleksandra.homebudget.repository.person;

import java.util.List;
import java.util.Optional;
import pl.glozaaleksandra.homebudget.Person;

public interface PersonRepository {

  Person addNewPerson(String name);
  List<Person> findAllPersons();
  Optional<Person> getByName(String name);
}
