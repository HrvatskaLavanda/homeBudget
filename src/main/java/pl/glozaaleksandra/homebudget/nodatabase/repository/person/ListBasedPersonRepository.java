package pl.glozaaleksandra.homebudget.nodatabase.repository.person;

import org.springframework.stereotype.Repository;
import pl.glozaaleksandra.homebudget.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ListBasedPersonRepository implements PersonRepository {
  private List<Person> persons = new ArrayList<>();

  @Override
  public Person addNewPerson(String name) {
    Person savedPerson = Person.builder()
        .name(name)
        .build();
    persons.add(savedPerson);
    return savedPerson;
  }

  @Override
  public List<Person> findAllPersons() {
    return persons;
  }

  @Override
  public Optional<Person> getByName(String name) {
    return persons.stream().filter(person -> person.getName().equals(name)).findFirst();
  }


}
