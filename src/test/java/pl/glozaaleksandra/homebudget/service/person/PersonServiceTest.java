package pl.glozaaleksandra.homebudget.service.person;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.person.PersonRepository;

class PersonServiceTest {

  public static final String ANY_PERSON_NAME = "anyName";
  @Mock
  private PersonRepository personRepository;
  @Mock
  private Person person;

  private PersonService personService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    personService = new PersonService(personRepository);
  }

  @Test
  public void shouldAddNewPerson() {
    // given
    when(personRepository.addNewPerson(eq(ANY_PERSON_NAME))).thenReturn(person);

    //when
    Person newPerson = personService.saveNewPerson(ANY_PERSON_NAME);

    //then
    verify(personRepository).addNewPerson(ANY_PERSON_NAME);
    Assertions.assertEquals(person, newPerson, "saved new person had different data than expected!");
  }


  @Test
  public void shouldReturnTrueIfPersonExists() {
    // given
    when(personRepository.getByName(eq(ANY_PERSON_NAME))).thenReturn(Optional.of(person));

    //when
    boolean actual = personService.personExistsByName(ANY_PERSON_NAME);

    //then
    verify(personRepository).getByName(eq(ANY_PERSON_NAME));
    Assertions.assertTrue(actual);
  }

  @Test
  public void shouldReturnTrueIfPersonDoesNotExist() {
    // given
    when(personRepository.getByName(eq(ANY_PERSON_NAME))).thenReturn(Optional.empty());

    //when
    boolean actual = personService.personExistsByName(ANY_PERSON_NAME);

    //then
    verify(personRepository).getByName(eq(ANY_PERSON_NAME));
    Assertions.assertFalse(actual);
  }

  @Test
  public void shouldReturnPersonIfPersonExists() {
    // given
    when(personRepository.getByName(eq(ANY_PERSON_NAME))).thenReturn(Optional.of(person));

    //when
    var actual = personService.getByName(ANY_PERSON_NAME);

    //then
    verify(personRepository).getByName(eq(ANY_PERSON_NAME));
    Assertions.assertEquals(person, actual);
  }

  @Test
  public void shouldThrowExceptionWhenPersonNotFound() {
    // given
    when(personRepository.getByName(eq(ANY_PERSON_NAME))).thenReturn(Optional.empty());

    //when then
    Assertions.assertThrows(IllegalStateException.class, () ->
        personService.getByName(ANY_PERSON_NAME)
    );
    verify(personRepository).getByName(eq(ANY_PERSON_NAME));
  }

}