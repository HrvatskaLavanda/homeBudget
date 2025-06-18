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

        var foodCategory = new Category("food");
        var cleaningCategory = new Category("cleaning");
        var developmentCategory = new Category("development");
        var entertainmentCategory = new Category("entertainment");

        var cinema = new Product(BigDecimal.valueOf(100), "cinema", entertainmentCategory);
        var tonic = new Product(BigDecimal.valueOf(9), "tonic", foodCategory);
        var tuna = new Product(BigDecimal.valueOf(5), "tuna", foodCategory);

        categoryRepository.save(foodCategory);
        categoryRepository.save(cleaningCategory);
        categoryRepository.save(developmentCategory);
        categoryRepository.save(entertainmentCategory);

        categoryRepository.delete("food");

        List<Category> categories = categoryRepository.findAll();

        categoryRepository.update(entertainmentCategory, "bread");

        Category foundCategory = categoryRepository.findByName("bread");

        for (Category c : categories) {
            System.out.println(c.getName());
        }

        System.out.println("Found category: " + foundCategory);

        System.out.println("------------------------");
        System.out.println("Product section: ");

        productRepository.save(cinema);
        productRepository.save(tonic);
        productRepository.save(tuna);

        List<Product> allProducts = productRepository.findAll();
        System.out.println("All products: " + allProducts);

        Product foundProduct = productRepository.findByName("cinema");
        System.out.println("Found product: " + foundProduct);

        productRepository.update(cinema, "theater");

        Product foundProduct1 = productRepository.findByName("theater");
        System.out.println("Found updated product: " + foundProduct1);

        productRepository.delete("theater");

        allProducts = productRepository.findAll();
        System.out.println("All products: " + allProducts);
    }


}
