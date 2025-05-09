package pl.glozaaleksandra.homebudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {
//		SpringApplication.run(HomebudgetApplication.class, args);
        ListBasedCategoryRepository listBasedCategoryRepository = new ListBasedCategoryRepository();
        List<Category> all = listBasedCategoryRepository.findAll();
        System.out.println(all);
    }

}
