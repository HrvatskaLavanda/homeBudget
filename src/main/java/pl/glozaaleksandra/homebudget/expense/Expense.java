package pl.glozaaleksandra.homebudget.expense;

import pl.glozaaleksandra.homebudget.Person;
import pl.glozaaleksandra.homebudget.product.Product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Expense {
    private Person buyer;
    private List<Product> products;
    private Instant expenseDatetime;

    public Expense(Person buyer, List<Product> products, Instant expenseDatetime) {
        this.buyer = buyer;
        this.products = products;
        this.expenseDatetime = expenseDatetime;
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
