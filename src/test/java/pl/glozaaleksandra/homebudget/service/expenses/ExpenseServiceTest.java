package pl.glozaaleksandra.homebudget.service.expenses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.expense.Expense;
import pl.glozaaleksandra.homebudget.repository.expense.ExpenseRepository;
import pl.glozaaleksandra.homebudget.repository.product.Product;
import pl.glozaaleksandra.homebudget.service.person.PersonService;
import pl.glozaaleksandra.homebudget.service.person.PersonServiceTest;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private PersonService personService;

    @Mock
    private Product product1;

    @Mock
    private Product product2;

    @Mock
    private Person person;

    @Mock
    private Expense expense;

    @Mock
    private static List<Person> people;

    private ExpenseService expenseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expenseService = new ExpenseService(expenseRepository, personService);
    }

    public static final Instant purchaseTime = Instant.now();
    public static final String buyerName = PersonServiceTest.ANY_NAME;

    @Test
    public void shouldAddNewExpense() {
        // given
        List<Product> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(buyerName))).thenReturn(true);
        when(personService.getByName(eq(buyerName))).thenReturn(person);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDatetime()).thenReturn(purchaseTime);
        when(expense.getBuyer()).thenReturn(person);
        when(expense.getProducts()).thenReturn(products);

        // when
        Expense expected = expenseService.addNewExpense(buyerName, products, purchaseTime);

        // then
        Assertions.assertEquals(purchaseTime, expected.getExpenseDatetime());
        Assertions.assertEquals(person, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());
    }

    @Test
    public void shouldAddNewPersonWithExpenseIfNotOnTheList() {
        //given
        Person newPerson = new Person(buyerName);
        List<Product> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(buyerName))).thenReturn(false);
        //jeżeli osoby nie ma to dodaj:
        when(personService.saveNewPerson(eq(buyerName))).thenReturn(new Person(buyerName));
        when(personService.getByName(eq(buyerName))).thenReturn(newPerson);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDatetime()).thenReturn(purchaseTime);
        when(expense.getBuyer()).thenReturn(newPerson);
        when(expense.getProducts()).thenReturn(products);

        //when
        Expense expected = expenseService.addNewExpense(buyerName, products, purchaseTime);

        //then
        Assertions.assertEquals(purchaseTime, expected.getExpenseDatetime());
        Assertions.assertEquals(newPerson, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());

    }

    private static Stream<Arguments> allNullEmptyFutureTimeExamples() {
        return Stream.of(
                Arguments.of(null, people, purchaseTime),
                Arguments.of(PersonServiceTest.ANY_NAME, null, purchaseTime),
                Arguments.of(PersonServiceTest.ANY_NAME, people, null),
                Arguments.of(" ", people, purchaseTime),
                Arguments.of(PersonServiceTest.ANY_NAME, List.of(), purchaseTime),
                Arguments.of(PersonServiceTest.ANY_NAME, people, Instant.now().plus(Duration.ofMinutes(5)))
        );
    }

    @ParameterizedTest
    @MethodSource("allNullEmptyFutureTimeExamples")
    public void shouldThrowExceptionWhenAnyExpenseParameterIsNull(String buyerName, List<Product> boughtProducts, Instant purchaseTime) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> expenseService.addNewExpense(buyerName, boughtProducts, purchaseTime));
    }
}