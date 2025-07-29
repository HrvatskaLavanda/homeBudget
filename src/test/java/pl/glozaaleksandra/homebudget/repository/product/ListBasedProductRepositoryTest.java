package pl.glozaaleksandra.homebudget.repository.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.glozaaleksandra.homebudget.repository.category.Category;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ListBasedProductRepositoryTest {

    @Mock
    private ListBasedProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ListBasedProductRepository();
    }

    private static final Category FRUITS_CATEGORY = new Category("Fruits");
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


}