package pl.glozaaleksandra.homebudget.product;

import java.util.ArrayList;
import java.util.List;

public class ListBasedProductRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
