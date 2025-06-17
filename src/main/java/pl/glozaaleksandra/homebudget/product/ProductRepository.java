package pl.glozaaleksandra.homebudget.product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
