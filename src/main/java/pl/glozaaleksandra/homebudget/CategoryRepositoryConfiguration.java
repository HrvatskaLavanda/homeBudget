package pl.glozaaleksandra.homebudget;

import org.springframework.context.annotation.Configuration;
import pl.glozaaleksandra.homebudget.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;

@Configuration
public class CategoryRepositoryConfiguration {

//  @Bean
  public CategoryRepository listBasedCategoryRepository(){
    return new ListBasedCategoryRepository();
  }
}
