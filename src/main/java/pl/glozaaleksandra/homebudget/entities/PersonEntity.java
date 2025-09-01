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
@Table(name = "person")
@Entity
public class PersonEntity {
    @Id
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
