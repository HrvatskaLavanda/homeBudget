package pl.glozaaleksandra.homebudget.expense;

import java.util.ArrayList;
import java.util.List;

public class ListBasedExpenseRepository implements ExpenseRepository {

    private List<Expense> expenses = new ArrayList<>();

    @Override
    public List<Expense> findAll() {
        return expenses;
    }

    @Override
    public void save(Expense expense) {
        expenses.add(expense);
    }
}
