package pl.glozaaleksandra.homebudget.product;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.glozaaleksandra.homebudget.category.Category;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode
@ToString
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
