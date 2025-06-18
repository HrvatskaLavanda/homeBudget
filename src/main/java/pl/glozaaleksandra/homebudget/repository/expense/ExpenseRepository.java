package pl.glozaaleksandra.homebudget.repository.expense;

import pl.glozaaleksandra.homebudget.Person;

import java.util.List;

public interface ExpenseRepository {
    List<Expense> findAll();

    Expense save(Expense expense);

    void delete(Expense expense);

    Expense findByPerson(Person buyer);
}
