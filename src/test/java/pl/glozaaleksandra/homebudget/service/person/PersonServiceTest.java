package pl.glozaaleksandra.homebudget.service.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;
import pl.glozaaleksandra.homebudget.repository.PersonRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

  public static final String ANY_PERSON_NAME = "anyName";
  public static final String ANY_NAME = "Tomek";
  @Mock
  private PersonRepository personRepository;
  @Mock
  private PersonEntity person;

  private PersonService personService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    personService = new PersonService(personRepository);
  }

  @Test
  public void shouldAddNewPerson() {
    //given
      when(personRepository.findByPersonName(eq(ANY_NAME))).thenReturn(Optional.empty());
      when(personRepository.save(any())).thenReturn(person);
      when(person.getPersonName()).thenReturn(ANY_NAME);

    //when
      PersonEntity expected = personService.saveNewPerson(ANY_NAME);

    //then
      Assertions.assertEquals(ANY_NAME, expected.getPersonName());
  }


  @Test
  public void shouldReturnTrueIfPersonExists() {
    // given
      when(personRepository.findByPersonName(eq(ANY_PERSON_NAME))).thenReturn(Optional.of(person));

    //when
    boolean actual = personService.personExistsByName(ANY_PERSON_NAME);

    //then
      verify(personRepository).findByPersonName(eq(ANY_PERSON_NAME));
    Assertions.assertTrue(actual);
  }

  @Test
  public void shouldReturnTrueIfPersonDoesNotExist() {
    // given
      when(personRepository.findByPersonName(eq(ANY_PERSON_NAME))).thenReturn(Optional.empty());

    //when
    boolean actual = personService.personExistsByName(ANY_PERSON_NAME);

    //then
      verify(personRepository).findByPersonName(eq(ANY_PERSON_NAME));
    Assertions.assertFalse(actual);
  }

  @Test
  public void shouldReturnPersonIfPersonExists() {
    // given
      when(personRepository.findByPersonName(eq(ANY_PERSON_NAME))).thenReturn(Optional.of(person));

    //when
    var actual = personService.getByName(ANY_PERSON_NAME);

    //then
      verify(personRepository).findByPersonName(eq(ANY_PERSON_NAME));
    Assertions.assertEquals(person, actual);
  }

  @Test
  public void shouldThrowExceptionWhenPersonNotFound() {
    // given
      when(personRepository.findByPersonName(eq(ANY_PERSON_NAME))).thenReturn(Optional.empty());

    //when then
    Assertions.assertThrows(IllegalStateException.class, () ->
        personService.getByName(ANY_PERSON_NAME)
    );
      verify(personRepository).findByPersonName(eq(ANY_PERSON_NAME));
  }

}