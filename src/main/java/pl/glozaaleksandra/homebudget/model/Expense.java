package pl.glozaaleksandra.homebudget.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Expense {
    private Person buyer;
    private List<Product> products;
    private Instant expenseDatetime;

    public BigDecimal getFullPrice() {
        BigDecimal sumPrice = BigDecimal.valueOf(0);
        for (Product product : products) {
            BigDecimal productPrice = product.getPrice();
            sumPrice = sumPrice.add(productPrice);
        }
        return sumPrice;
    }


}
