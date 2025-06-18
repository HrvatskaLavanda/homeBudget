package pl.glozaaleksandra.homebudget.repository.product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Product findByName(String productName);

    void update(Product product, String newProductName);

    void delete(String productName);
}
