package pl.glozaaleksandra.homebudget.model;

import lombok.*;
import pl.glozaaleksandra.homebudget.entities.ProductEntity;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer categoryId;
    private String name;
    private List<ProductEntity> products;
}
