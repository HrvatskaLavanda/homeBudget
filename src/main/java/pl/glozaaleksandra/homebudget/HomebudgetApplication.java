package pl.glozaaleksandra.homebudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {
//		SpringApplication.run(HomebudgetApplication.class, args);
        ListBasedCategoryRepository listBasedCategoryRepository = new ListBasedCategoryRepository();

        var category = new Category("food");
        var category1 = new Category("cleaning");
        var category2 = new Category("development");
        var category3 = new Category("entertainment");

        listBasedCategoryRepository.save(category);
        listBasedCategoryRepository.save(category1);
        listBasedCategoryRepository.save(category2);
        listBasedCategoryRepository.save(category3);

        listBasedCategoryRepository.delete("food");

        List<Category> categories = listBasedCategoryRepository.findAll();

        listBasedCategoryRepository.update(category3, "leisure");

        for (Category c : categories) {
            System.out.println(c.getName());
        }
    }

}
