package pl.glozaaleksandra.homebudget.service.expenses;

import lombok.AllArgsConstructor;
import pl.glozaaleksandra.homebudget.model.Expense;
import pl.glozaaleksandra.homebudget.model.Person;
import pl.glozaaleksandra.homebudget.model.Product;
import pl.glozaaleksandra.homebudget.nodatabase.repository.expense.ExpenseRepository;
import pl.glozaaleksandra.homebudget.service.person.PersonService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private PersonService personService;

    public Expense addNewExpense(String buyerName, List<Product> boughtProducts, Instant purchaseTime) {
        Person person;
        if (buyerName == null) {
            throw new IllegalArgumentException("Buyer name is null.");
        }
        if (boughtProducts == null || boughtProducts.isEmpty()) {
            throw new IllegalArgumentException("Buyer name is null.");
        }
        if (personService.personExistsByName(buyerName)) {
            person = personService.getByName(buyerName);
        } else {
            person = personService.saveNewPerson(buyerName);
        }
        Expense expense = Expense.builder()
                .expenseDatetime(purchaseTime)
                .buyer(person)
                .products(boughtProducts)
                .build();
        return expenseRepository.save(expense);
    }

    public Optional<Expense> getExpenseByPurchaseDateTime(Instant purchaseTime) {
        if (purchaseTime == null) {
            throw new IllegalArgumentException("No purchase time");
        }
        List<Expense> expenses = expenseRepository.findAll();
        for (Expense expense : expenses)
            if (purchaseTime.equals(expense.getExpenseDatetime())) {
                return Optional.of(expense);
            }
        return Optional.empty();
    }
}
