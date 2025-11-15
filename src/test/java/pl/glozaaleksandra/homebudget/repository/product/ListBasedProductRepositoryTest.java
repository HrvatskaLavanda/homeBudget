package pl.glozaaleksandra.homebudget.repository.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.glozaaleksandra.homebudget.model.Category;
import pl.glozaaleksandra.homebudget.model.Product;
import pl.glozaaleksandra.homebudget.nodatabase.repository.product.ListBasedProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ListBasedProductRepositoryTest {

    private ListBasedProductRepository repository = new ListBasedProductRepository();

    private static final Category FRUITS_CATEGORY = Category.builder()
            .name("Fruits")
            .build();

    private static final Product PRODUCT = new Product(BigDecimal.valueOf(100), "apple", FRUITS_CATEGORY);

    @Test
    public void shouldAddNewProduct() {
        //given

        //when
        Product actualProduct = repository.save(PRODUCT);

        //then
        Assertions.assertEquals(actualProduct, PRODUCT);
    }

    @Test
    public void shouldFindAllProducts() {
        //given
        List<Product> expectedAllProducts = new ArrayList<>();

        //when
        List<Product> actualAllProducts = repository.findAll();

        //then
        Assertions.assertEquals(actualAllProducts, expectedAllProducts);

    }

    @Test
    public void shouldFindProductByName() {
        //given
        repository.save(PRODUCT);
        String productName = PRODUCT.getName();
        //when
        Optional<Product> actualFoundProduct = repository.findByName(productName);

        //then
        Assertions.assertNotNull(actualFoundProduct);
        Assertions.assertTrue(actualFoundProduct.isPresent());

    }

    @Test
    public void shouldUpdateProduct() {
        //given
        repository.save(PRODUCT);
        String newProductName = "banana";

        //when
        repository.update(PRODUCT, newProductName);

        //then
        Assertions.assertEquals(newProductName, PRODUCT.getName());

    }

    @Test
    public void shouldDeleteProduct() {
        //given
        repository.save(PRODUCT);
        String productName = PRODUCT.getName();

        //when
        repository.delete(productName);

        //then
        Optional<Product> productToBeDeleted = repository.findByName(productName);
        Assertions.assertTrue(productToBeDeleted.isEmpty());

    }
}