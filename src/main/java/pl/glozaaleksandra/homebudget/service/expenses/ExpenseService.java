package pl.glozaaleksandra.homebudget.service.expenses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.glozaaleksandra.homebudget.entities.BoughtProductsEntity;
import pl.glozaaleksandra.homebudget.entities.ExpenseEntity;
import pl.glozaaleksandra.homebudget.entities.PersonEntity;
import pl.glozaaleksandra.homebudget.repository.ExpenseRepository;
import pl.glozaaleksandra.homebudget.service.person.PersonService;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private PersonService personService;

    public ExpenseEntity addNewExpense(String buyerName, List<BoughtProductsEntity> boughtProducts, Instant purchaseTime) {
        PersonEntity person;
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
        ExpenseEntity expense = ExpenseEntity.builder()
                .expenseDateTime(purchaseTime)
                .person(person)
                .boughtProducts(boughtProducts)
                .totalPrice(BigDecimal.valueOf(100))
                .build();
        return expenseRepository.save(expense);
    }

    public Optional<ExpenseEntity> getExpenseByPurchaseDateTime(Instant purchaseTime) {
        if (purchaseTime == null) {
            throw new IllegalArgumentException("No purchase time");
        }
        List<ExpenseEntity> expenses = expenseRepository.findAll();
        for (ExpenseEntity expense : expenses)
            if (purchaseTime.equals(expense.getExpenseDateTime())) {
                return Optional.of(expense);
            }
        return Optional.empty();
    }

    public List<ExpenseEntity> getAll() {
        List<ExpenseEntity> allExpenses = expenseRepository.findAll();
        return allExpenses;
    }
}
