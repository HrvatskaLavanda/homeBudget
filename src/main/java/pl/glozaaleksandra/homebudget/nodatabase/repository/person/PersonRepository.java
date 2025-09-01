package pl.glozaaleksandra.homebudget.nodatabase.repository.person;

import pl.glozaaleksandra.homebudget.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

  Person addNewPerson(String name);

  List<Person> findAllPersons();

  Optional<Person> getByName(String name);
}
