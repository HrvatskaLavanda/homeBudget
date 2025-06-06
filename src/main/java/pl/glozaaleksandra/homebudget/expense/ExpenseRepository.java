package pl.glozaaleksandra.homebudget.expense;

import java.util.List;

public interface ExpenseRepository {
    List<Expense> findAll();

    void save(Expense expense);

    void delete(Expense expense);
}
