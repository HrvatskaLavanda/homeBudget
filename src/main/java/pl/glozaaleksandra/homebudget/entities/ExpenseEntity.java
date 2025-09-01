package pl.glozaaleksandra.homebudget.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expense")
@Entity
public class ExpenseEntity {
    @Id
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "expense_date_time")
    private Instant expenseDateTime;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private PersonEntity personEntity;

    @OneToOne
    @JoinColumn(name = "expense_id", referencedColumnName = "expense_id")
    private BoughtProductsEntity boughtProductsEntity;

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "expenseId=" + expenseId +
                ", totalPrice=" + totalPrice +
                ", expenseDateTime=" + expenseDateTime +
                '}';
    }
}
