package pl.glozaaleksandra.homebudget.expense;

import pl.glozaaleksandra.homebudget.Person;

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

    @Override
    public void delete(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public Expense findByPerson(Person buyer) {
        for (Expense expense : expenses) {
            if (expense.getBuyer().equals(buyer)) {
                return expense;
            }
        }
        throw new IllegalArgumentException("Expense for:  " + buyer + " not found");
    }
}
