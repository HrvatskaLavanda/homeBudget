package pl.glozaaleksandra.homebudget.repository.expense;

import pl.glozaaleksandra.homebudget.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListBasedExpenseRepository implements ExpenseRepository {

    private List<Expense> expenses = new ArrayList<>();

    @Override
    public List<Expense> findAll() {
        return expenses;
    }

    @Override
    public Expense save(Expense expense) {
        expenses.add(expense);
        return expense;
    }

    @Override
    public boolean delete(Expense expense) {
        return expenses.stream()
                .filter(foundExpense -> foundExpense.equals(expense))
                .findFirst()
                .map(foundExpense -> expenses.remove(foundExpense))
                .orElse(false);
    }

    @Override
    public Optional<Expense> findByPerson(Person buyer) {
//        for (Expense expense : expenses) {
//            if (expense.getBuyer().equals(buyer)) {
//                return expense;
//            }
//        }

        return expenses.stream()
                .filter(expense -> expense.getBuyer().equals(buyer))
                .findFirst();
    }
}
