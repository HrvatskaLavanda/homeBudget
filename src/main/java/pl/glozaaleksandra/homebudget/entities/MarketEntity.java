package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "markets")
@Entity
public class MarketEntity {
    @Id
    @Column(name = "market_id")
    private int marketId;

    @Column(name = "market_name")
    private String marketName;

    @OneToMany(mappedBy = "market")
    private List<BoughtProductsEntity> boughtProducts;

    @Override
    public String toString() {
        return "MarketEntity{" +
                "marketId=" + marketId +
                ", marketName='" + marketName + '\'' +
                '}';
    }
}
