package pl.glozaaleksandra.homebudget.repository.product;

import lombok.*;
import pl.glozaaleksandra.homebudget.repository.category.Category;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@Setter
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
