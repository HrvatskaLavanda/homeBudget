package pl.glozaaleksandra.homebudget.repository.expense;

import pl.glozaaleksandra.homebudget.Person;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
    List<Expense> findAll();

    Expense save(Expense expense);

    boolean delete(Expense expense);

    Optional<Expense> findByPerson(Person buyer);
}
