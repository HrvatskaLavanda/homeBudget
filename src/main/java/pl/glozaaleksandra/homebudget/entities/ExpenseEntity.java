package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expense")
@Entity
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "expense_date_time")
    private Instant expenseDateTime;

    @OneToMany(mappedBy = "expense")
    private List<BoughtProductsEntity> boughtProducts;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private PersonEntity person;

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "expenseId=" + expenseId +
                ", totalPrice=" + totalPrice +
                ", expenseDateTime=" + expenseDateTime +
                '}';
    }
}
