package pl.glozaaleksandra.homebudget.service.expenses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.entities.BoughtProductsEntity;
import pl.glozaaleksandra.homebudget.entities.ExpenseEntity;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;
import pl.glozaaleksandra.homebudget.repository.ExpenseRepository;
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
    private BoughtProductsEntity product1;

    @Mock
    private BoughtProductsEntity product2;

    @Mock
    private PersonEntity person;

    @Mock
    private ExpenseEntity expense;

    @Mock
    private ExpenseEntity expense2;

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
        when(expense.getExpenseDateTime()).thenReturn(Instant.now().plus(Duration.ofMinutes(5)));
        when(expense2.getExpenseDateTime()).thenReturn(PURCHASE_TIME);

        // when
        Optional<ExpenseEntity> actual = expenseService.getExpenseByPurchaseDateTime(PURCHASE_TIME);

        // then
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(actual.get(), expense2);
    }

    @Test
    public void shouldNotGetExpenseByDateTime() {
        //given
        when(expenseRepository.findAll()).thenReturn(List.of(expense, expense2));
        when(expense.getExpenseDateTime()).thenReturn(Instant.now().plus(Duration.ofMinutes(5)));
        when(expense2.getExpenseDateTime()).thenReturn(Instant.now().plus(Duration.ofMinutes(15)));


        //when
        Optional<ExpenseEntity> actual = expenseService.getExpenseByPurchaseDateTime(PURCHASE_TIME);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldAddNewExpense() {
        // given
        List<BoughtProductsEntity> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(ANY_NAME))).thenReturn(true);
        when(personService.getByName(eq(ANY_NAME))).thenReturn(person);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDateTime()).thenReturn(PURCHASE_TIME);
        when(expense.getPerson()).thenReturn(person);
        when(expense.getBoughtProducts()).thenReturn(products);

        // when
        ExpenseEntity expected = expenseService.addNewExpense(ANY_NAME, products, PURCHASE_TIME);

        // then
        Assertions.assertEquals(PURCHASE_TIME, expected.getExpenseDateTime());
        Assertions.assertEquals(person, expected.getPerson());
        Assertions.assertEquals(products, expected.getBoughtProducts());
    }

    @Test
    public void shouldAddNewPersonWithExpenseIfNotOnTheList() {
        //given
        PersonEntity newPerson = new PersonEntity();
        List<BoughtProductsEntity> products = List.of(product1, product2);
        when(personService.personExistsByName(eq(ANY_NAME))).thenReturn(false);
        //jeżeli osoby nie ma to dodaj:
        when(personService.saveNewPerson(eq(ANY_NAME))).thenReturn(newPerson);
        when(personService.getByName(eq(ANY_NAME))).thenReturn(newPerson);
        when(expenseRepository.save(any())).thenReturn(expense);
        when(expense.getExpenseDateTime()).thenReturn(PURCHASE_TIME);
        when(expense.getPerson()).thenReturn(newPerson);
        when(expense.getBoughtProducts()).thenReturn(products);

        //when
        ExpenseEntity expected = expenseService.addNewExpense(ANY_NAME, products, PURCHASE_TIME);

        //then
        Assertions.assertEquals(PURCHASE_TIME, expected.getExpenseDateTime());
        Assertions.assertEquals(newPerson, expected.getPerson());
        Assertions.assertEquals(products, expected.getBoughtProducts());

    }

    private static Stream<Arguments> allNullEmptyFutureTimeExamples() {
        return Stream.of(
                Arguments.of(null, List.of(), PURCHASE_TIME),
                Arguments.of(ANY_NAME, null, PURCHASE_TIME),
                Arguments.of(ANY_NAME, List.of(), null),
                Arguments.of(" ", List.of(), PURCHASE_TIME),
                Arguments.of(ANY_NAME, List.of(), PURCHASE_TIME),
                Arguments.of(ANY_NAME, List.of(), Instant.now().plus(Duration.ofMinutes(5)))
        );
    }

    @ParameterizedTest
    @MethodSource("allNullEmptyFutureTimeExamples")
    public void shouldThrowExceptionWhenAnyExpenseParameterIsNull(String buyerName, List<BoughtProductsEntity> boughtProducts, Instant purchaseTime) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> expenseService.addNewExpense(buyerName, boughtProducts, purchaseTime));
    }

    @ParameterizedTest
    @NullSource
    public void shouldThrowExceptionWhenPurchaseTimeIsNull(Instant purchaseTime) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> expenseService.getExpenseByPurchaseDateTime(purchaseTime));
    }
}