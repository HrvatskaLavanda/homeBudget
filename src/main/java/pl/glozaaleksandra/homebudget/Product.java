package pl.glozaaleksandra.homebudget;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;
    private String name;
    private Category category;

    public Product(BigDecimal price, String name, Category category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
