package pl.glozaaleksandra.homebudget.repository.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Product> findByName(String productName) {
//        for (Product product : products) {
//            if (productName.equals(product.getName())) {
//                return product;
//            }
//        }

        return products.stream()
                .filter(product -> productName.equals(product.getName()))
                .findFirst();
//        throw new IllegalArgumentException("Product:  " + productName + " not found");
    }

    @Override
    public void update(Product product, String newProductName) {
        Optional<Product> foundProduct = findByName(product.getName());
        foundProduct.ifPresent(product1 -> product1.setName(newProductName));
    }

    @Override
    public boolean delete(String productName) {
        Optional<Product> productToBeDeleted = findByName(productName);
        products.remove(productToBeDeleted);
        return productToBeDeleted
                .map(foundProductName -> products.remove(foundProductName))
                .orElse(false);
    }
}
