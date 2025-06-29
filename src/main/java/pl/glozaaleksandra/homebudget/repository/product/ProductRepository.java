package pl.glozaaleksandra.homebudget.repository.product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findByName(String productName);

    void update(Product product, String newProductName);

    boolean delete(String productName);
}
