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

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "expenseId=" + expenseId +
                ", totalPrice=" + totalPrice +
                ", expenseDateTime=" + expenseDateTime +
                '}';
    }
}
