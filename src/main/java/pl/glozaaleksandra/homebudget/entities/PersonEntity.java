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
@Table(name = "person")
@Entity
public class PersonEntity {
    @Id
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @OneToMany(mappedBy = "person")
    private List<ExpenseEntity> expenses;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
