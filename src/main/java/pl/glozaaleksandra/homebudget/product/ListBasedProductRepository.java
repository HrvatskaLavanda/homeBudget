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

    @Override
    public Product findByName(String productName) {
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                return product;
            }
        }
        throw new IllegalArgumentException("Product:  " + productName + " not found");
    }

    @Override
    public void update(Product product, String newProductName) {
        Product foundProduct = findByName(product.getName());
        foundProduct.setName(newProductName);
    }
}
