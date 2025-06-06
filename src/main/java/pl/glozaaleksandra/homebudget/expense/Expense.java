package pl.glozaaleksandra.homebudget.expense;

import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.product.Product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Expense {
    private Person buyer;
    private List<Product> products;
    private Instant expenseDatetime;

    public Expense(Person buyer, List<Product> products, Instant expenseDatetime) {
        this.buyer = buyer;
        this.products = products;
        this.expenseDatetime = expenseDatetime;
    }

    public Person getBuyer() {
        return buyer;
    }

    public Expense setBuyer(Person buyer) {
        this.buyer = buyer;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Expense setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(buyer, expense.buyer) && Objects.equals(products, expense.products) && Objects.equals(expenseDatetime, expense.expenseDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, products, expenseDatetime);
    }

    public Instant getExpenseDatetime() {
        return expenseDatetime;
    }

    public Expense setExpenseDatetime(Instant expenseDatetime) {
        this.expenseDatetime = expenseDatetime;
        return this;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "buyer=" + buyer +
                ", products=" + products +
                ", expenseDatetime=" + expenseDatetime +
                '}';
    }

    public BigDecimal getFullPrice() {
        BigDecimal sumPrice = BigDecimal.valueOf(0);
        for (Product product : products) {
            BigDecimal productPrice = product.getPrice();
            sumPrice = sumPrice.add(productPrice);
        }
        return sumPrice;
    }


}
