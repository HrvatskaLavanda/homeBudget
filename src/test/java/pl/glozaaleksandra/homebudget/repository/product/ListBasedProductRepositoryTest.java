package pl.glozaaleksandra.homebudget.repository.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.glozaaleksandra.homebudget.repository.category.Category;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ListBasedProductRepositoryTest {
    @Mock
    ListBasedProductRepository repository = new ListBasedProductRepository();

    @Test
    public void shouldAddNewProduct() {
        //given

        Category fruitsCategory = new Category("Fruits");
        Product expectedProduct = new Product(BigDecimal.valueOf(100), "apple", fruitsCategory);

        //when
        Product actualProduct = repository.save(expectedProduct);

        //then
        Assertions.assertEquals(actualProduct, expectedProduct);
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


}