package pl.glozaaleksandra.homebudget.service.expenses;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.repository.expense.Expense;
import pl.glozaaleksandra.homebudget.repository.expense.ExpenseRepository;
import pl.glozaaleksandra.homebudget.repository.product.Product;
import pl.glozaaleksandra.homebudget.service.person.PersonService;

@AllArgsConstructor
public class ExpenseService {
  private ExpenseRepository expenseRepository;
  private PersonService personService;

  public Expense addNewExpense(String buyerName, List<Product> boughtProducts, Instant purchaseTime){
    Person person;
    if (personService.personExistsByName(buyerName)){
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
}
