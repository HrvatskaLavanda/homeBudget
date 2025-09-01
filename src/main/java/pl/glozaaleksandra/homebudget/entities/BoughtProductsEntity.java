package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
