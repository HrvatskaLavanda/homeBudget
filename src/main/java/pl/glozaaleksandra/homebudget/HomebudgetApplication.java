package pl.glozaaleksandra.homebudget;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.glozaaleksandra.homebudget.category.Category;
import pl.glozaaleksandra.homebudget.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;
import pl.glozaaleksandra.homebudget.product.ListBasedProductRepository;
import pl.glozaaleksandra.homebudget.product.Product;
import pl.glozaaleksandra.homebudget.product.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {
        CategoryRepository categoryRepository = new ListBasedCategoryRepository();
        ProductRepository productRepository = new ListBasedProductRepository();

        var category = new Category("food");
        var category1 = new Category("cleaning");
        var category2 = new Category("development");
        var category3 = new Category("entertainment");

        var product = new Product(BigDecimal.valueOf(100), "cinema", category3);
        var product1 = new Product(BigDecimal.valueOf(9), "tonic", category);
        var product2 = new Product(BigDecimal.valueOf(5), "tuna", category);

        categoryRepository.save(category);
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        categoryRepository.delete("food");

        List<Category> categories = categoryRepository.findAll();

        categoryRepository.update(category3, "bread");

        Category foundCategory = categoryRepository.findByName("bread");

        for (Category c : categories) {
            System.out.println(c.getName());
        }

        System.out.println("Found category: " + foundCategory);

        System.out.println("------------------------");
        System.out.println("Product section: ");

        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);


        List<Product> allProducts = productRepository.findAll();
        System.out.println("All products: " + allProducts);

        Product foundProduct = productRepository.findByName("cinema");
        System.out.println("Found product: " + foundProduct);

        productRepository.update(product, "theater");

        Product foundProduct1 = productRepository.findByName("theater");
        System.out.println("Found updated product: " + foundProduct1);

        productRepository.delete("theater");

        List<Product> allProducts1 = productRepository.findAll();
        System.out.println("All products: " + allProducts1);


    }


}
