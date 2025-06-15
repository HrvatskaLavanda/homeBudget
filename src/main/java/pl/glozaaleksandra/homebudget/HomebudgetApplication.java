package pl.glozaaleksandra.homebudget;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.glozaaleksandra.homebudget.category.Category;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;

import java.util.List;

@SpringBootApplication
public class HomebudgetApplication {

    public static void main(String[] args) {

//        // 1. tworzenie przez new
//        CategoryRepository categoryRepository = new ListBasedCategoryRepository();
//        CategoryService categoryService = new CategoryService(categoryRepository);
//
//        // 2. Fabryka
//        CategoryRepositoryFactory categoryRepositoryFactory = new CategoryRepositoryFactoryImpl();
//        CategoryRepository categoryRepository2 = categoryRepositoryFactory.createCategoryRepository();
//
//        // 3. statyczna metoda fabryczna
//        CategoryRepository categoryRepository3 = CategoryRepositoryStaticFactory.categoryRepository();
//
//        // 4. odwracamy! NIE MY robimy "new" - Inversion Of Control - Dependency Injection
//        ConfigurableApplicationContext context = SpringApplication.run(HomebudgetApplication.class, args);
//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
//
//        CategoryRepository category4 = context.getBean(ListBasedCategoryRepository.class);
//        CategoryService categoryService1 = context.getBean(CategoryService.class);
//        System.out.println("czy spring widzi?" + categoryService1.getCategoryRepository());

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

        listBasedCategoryRepository.update(category3, "bread");

        Category foundCategory = listBasedCategoryRepository.findByName("bread");

        for (Category c : categories) {
            System.out.println(c.getName());
        }

        System.out.println("Found category: " + foundCategory);
    }


}
