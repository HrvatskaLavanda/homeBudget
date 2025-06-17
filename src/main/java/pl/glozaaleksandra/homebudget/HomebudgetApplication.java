package pl.glozaaleksandra.homebudget;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.glozaaleksandra.homebudget.category.Category;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;
import pl.glozaaleksandra.homebudget.product.ListBasedProductRepository;
import pl.glozaaleksandra.homebudget.product.Product;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {
        ListBasedCategoryRepository listBasedCategoryRepository = new ListBasedCategoryRepository();
        ListBasedProductRepository listBasedProductRepository = new ListBasedProductRepository();

        var category = new Category("food");
        var category1 = new Category("cleaning");
        var category2 = new Category("development");
        var category3 = new Category("entertainment");

        var product = new Product(BigDecimal.valueOf(100), "cinema", category3);
        var product1 = new Product(BigDecimal.valueOf(9), "tonic", category);
        var product2 = new Product(BigDecimal.valueOf(5), "tuna", category);

        listBasedCategoryRepository.save(category);
        listBasedCategoryRepository.save(category1);
        listBasedCategoryRepository.save(category2);
        listBasedCategoryRepository.save(category3);

        listBasedCategoryRepository.delete("food");

        List<Category> categories = listBasedCategoryRepository.findAll();

        listBasedCategoryRepository.update(category3, "bread");

        Category foundCategory = listBasedCategoryRepository.findByName("bread");

        for (Category c : categories) {
            System.out.println(c.getName());
        }

        System.out.println("Found category: " + foundCategory);

        System.out.println("------------------------");
        System.out.println("Product section: ");

        listBasedProductRepository.save(product);
        listBasedProductRepository.save(product1);
        listBasedProductRepository.save(product2);

        List<Product> allProducts = listBasedProductRepository.findAll();
        System.out.println("All products: " + allProducts);

        Product foundProduct = listBasedProductRepository.findByName("cinema");
        System.out.println("Found product: " + foundProduct);

        listBasedProductRepository.update(product, "theater");

        Product foundProduct1 = listBasedProductRepository.findByName("theater");
        System.out.println("Found updated product: " + foundProduct1);

        listBasedProductRepository.delete("theater");

        List<Product> allProducts1 = listBasedProductRepository.findAll();
        System.out.println("All products: " + allProducts1);


    }


}
