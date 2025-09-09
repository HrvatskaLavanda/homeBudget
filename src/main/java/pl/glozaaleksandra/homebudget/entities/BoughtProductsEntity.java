package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bought_products")
@Entity
public class BoughtProductsEntity {
    @Id
    @Column(name = "bought_product_id")
    private int boughtProductId;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "expense_id", referencedColumnName = "expense_id")
    private ExpenseEntity expense;

    @ManyToOne
    @JoinColumn(name = "market_id", referencedColumnName = "market_id")
    private MarketEntity market;

    @Override
    public String toString() {
        return "BoughtProductsEntity{" +
                "boughtProductId=" + boughtProductId +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }
}
