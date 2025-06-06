package pl.glozaaleksandra.homebudget;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.glozaaleksandra.homebudget.category.Category;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;
import pl.glozaaleksandra.homebudget.expense.Expense;
import pl.glozaaleksandra.homebudget.expense.ListBasedExpenseRepository;

import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {
//		SpringApplication.run(HomebudgetApplication.class, args);
        ListBasedCategoryRepository listBasedCategoryRepository = new ListBasedCategoryRepository();
        ListBasedExpenseRepository listBasedExpenseRepository = new ListBasedExpenseRepository();

        var category = new Category("food");
        var category1 = new Category("cleaning");
        var category2 = new Category("development");
        var category3 = new Category("entertainment");

        listBasedCategoryRepository.save(category);
        listBasedCategoryRepository.save(category1);
        listBasedCategoryRepository.save(category2);
        listBasedCategoryRepository.save(category3);

        var person = new Person("Kasia");
        var person1 = new Person("Olek");

        var expense = new Expense(person, null, Instant.now());
        var expense1 = new Expense(person1, null, Instant.now());

        listBasedExpenseRepository.save(expense);
        listBasedExpenseRepository.save(expense1);

        listBasedExpenseRepository.delete(expense);

        List<Expense> expenses = listBasedExpenseRepository.findAll();

        listBasedCategoryRepository.delete("food");

        List<Category> categories = listBasedCategoryRepository.findAll();

        listBasedCategoryRepository.update(category3, "bread");

        Category foundCategory = listBasedCategoryRepository.findByName("bread");

        Expense foundExpense = listBasedExpenseRepository.findByPerson(person1);

        for (Category c : categories) {
            System.out.println(c.getName());
        }

        System.out.println("Found category: " + foundCategory);
        System.out.println("Found expense: " + foundExpense);

        System.out.println("Expenses:");
        for (Expense e : expenses) {
            System.out.println(e);
        }


    }

}
