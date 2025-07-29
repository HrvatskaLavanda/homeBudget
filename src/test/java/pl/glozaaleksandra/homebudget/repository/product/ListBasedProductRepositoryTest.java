package pl.glozaaleksandra.homebudget.repository.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.glozaaleksandra.homebudget.repository.category.Category;

import java.math.BigDecimal;

class ListBasedProductRepositoryTest {

    @Test
    public void shouldAddNewProduct() {
        //given
        ListBasedProductRepository repository = new ListBasedProductRepository();
        Category fruitsCategory = new Category("Fruits");
        Product expectedProduct = new Product(BigDecimal.valueOf(100), "apple", fruitsCategory);

        //when
        Product actualProduct = repository.save(expectedProduct);

        //then
        Assertions.assertEquals(actualProduct, expectedProduct);
    }


}