package pl.glozaaleksandra.homebudget.nodatabase.repository.category;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryRepositoryConfiguration {

//  @Bean
  public CategoryRepository listBasedCategoryRepository(){
    return new ListBasedCategoryRepository();
  }
}
