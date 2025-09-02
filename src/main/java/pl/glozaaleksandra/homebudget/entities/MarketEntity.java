package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "MarketEntity{" +
                "marketId=" + marketId +
                ", marketName='" + marketName + '\'' +
                '}';
    }
}
