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

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static pl.glozaaleksandra.homebudget.service.person.PersonServiceTest.ANY_NAME;

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
    private Expense expense2;

    @Mock
    private static List<Person> people;

    private ExpenseService expenseService;

    public static final Instant PURCHASE_TIME = Instant.now();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expenseService = new ExpenseService(expenseRepository, personService);
    }

    @Test
    public void shouldGetExpenseByDateTime() {
        // given
        when(expenseRepository.findAll()).thenReturn(List.of(expense, expense2));
        when(expense.getExpenseDatetime()).thenReturn(Instant.now().plus(Duration.ofMinutes(5)));
        when(expense2.getExpenseDatetime()).thenReturn(PURCHASE_TIME);

        // when
        Optional<Expense> actual = expenseService.getExpenseByPurchaseDateTime(PURCHASE_TIME);

        // then
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(actual.get(), expense2);
    }

    @Test
    public void shouldNotGetExpenseByDateTime() {
        //given
        when(expenseRepository.findAll()).thenReturn(List.of(expense, expense2));
        when(expense.getExpenseDatetime()).thenReturn(Instant.now().plus(Duration.ofMinutes(5)));
        when(expense2.getExpenseDatetime()).thenReturn(Instant.now().plus(Duration.ofMinutes(15)));


        //when
        Optional<Expense> actual = expenseService.getExpenseByPurchaseDateTime(PURCHASE_TIME);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldAddNewExpense() {
        // given
        List<Product> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(ANY_NAME))).thenReturn(true);
        when(personService.getByName(eq(ANY_NAME))).thenReturn(person);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDatetime()).thenReturn(PURCHASE_TIME);
        when(expense.getBuyer()).thenReturn(person);
        when(expense.getProducts()).thenReturn(products);

        // when
        Expense expected = expenseService.addNewExpense(ANY_NAME, products, PURCHASE_TIME);

        // then
        Assertions.assertEquals(PURCHASE_TIME, expected.getExpenseDatetime());
        Assertions.assertEquals(person, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());
    }

    @Test
    public void shouldAddNewPersonWithExpenseIfNotOnTheList() {
        //given
        Person newPerson = new Person(ANY_NAME);
        List<Product> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(ANY_NAME))).thenReturn(false);
        //jeżeli osoby nie ma to dodaj:
        when(personService.saveNewPerson(eq(ANY_NAME))).thenReturn(new Person(ANY_NAME));
        when(personService.getByName(eq(ANY_NAME))).thenReturn(newPerson);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDatetime()).thenReturn(PURCHASE_TIME);
        when(expense.getBuyer()).thenReturn(newPerson);
        when(expense.getProducts()).thenReturn(products);

        //when
        Expense expected = expenseService.addNewExpense(ANY_NAME, products, PURCHASE_TIME);

        //then
        Assertions.assertEquals(PURCHASE_TIME, expected.getExpenseDatetime());
        Assertions.assertEquals(newPerson, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());

    }

    private static Stream<Arguments> allNullEmptyFutureTimeExamples() {
        return Stream.of(
                Arguments.of(null, people, PURCHASE_TIME),
                Arguments.of(ANY_NAME, null, PURCHASE_TIME),
                Arguments.of(ANY_NAME, people, null),
                Arguments.of(" ", people, PURCHASE_TIME),
                Arguments.of(ANY_NAME, List.of(), PURCHASE_TIME),
                Arguments.of(ANY_NAME, people, Instant.now().plus(Duration.ofMinutes(5)))
        );
    }

    @ParameterizedTest
    @MethodSource("allNullEmptyFutureTimeExamples")
    public void shouldThrowExceptionWhenAnyExpenseParameterIsNull(String buyerName, List<Product> boughtProducts, Instant purchaseTime) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> expenseService.addNewExpense(buyerName, boughtProducts, purchaseTime));
    }
}