package pl.glozaaleksandra.homebudget.service.expenses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.expense.Expense;
import pl.glozaaleksandra.homebudget.repository.expense.ExpenseRepository;
import pl.glozaaleksandra.homebudget.repository.product.Product;
import pl.glozaaleksandra.homebudget.service.person.PersonService;

import java.time.Instant;
import java.util.List;

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
    private List<Person> people;

    private ExpenseService expenseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expenseService = new ExpenseService(expenseRepository, personService);
    }

    @Test
    public void shouldAddNewExpense() {
        // given
        String buyerName = "Tomek";
        List<Product> products = List.of(product1, product2);
        Instant purchaseTime = Instant.now();
        when(personService.personExistsByName(eq(buyerName))).thenReturn(true);
        when(personService.getByName(eq(buyerName))).thenReturn(person);
        when(expenseRepository.save(any())).thenReturn(expense);
        // todo - fill in when(expense....)

        // when
        Expense expected = expenseService.addNewExpense(buyerName, products, purchaseTime);

        // then
        Assertions.assertEquals(purchaseTime, expected.getExpenseDatetime());
        Assertions.assertEquals(person, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());
    }

    // todo 2nd test for else

    @Test
    public void shouldAddNewPersonWithExpenseIfNotOnTheList() {
        //given
        String buyerName = "Marek";
        List<Product> products = List.of(product1, product2);
        Instant purchaseTime = Instant.now();
        when(personService.personExistsByName(eq(buyerName))).thenReturn(false);
        //jeżeli osoby nie ma to dodaj:
        when(personService.saveNewPerson(eq(buyerName))).thenReturn(new Person(buyerName));
        when(personService.getByName(eq(buyerName))).thenReturn(person);
        when(expenseRepository.save(any())).thenReturn(expense);

        //when
        Expense expected = expenseService.addNewExpense(buyerName, products, purchaseTime);

        //then
        Assertions.assertEquals(purchaseTime, expected.getExpenseDatetime());
        Assertions.assertEquals(person, expected.getBuyer());
        Assertions.assertEquals(products, expected.getProducts());

    }

    // todo - tests for arguments (what if buyerName is null / empty? what if products null / empty? what if purchaseTime from
    //  future or null?
}