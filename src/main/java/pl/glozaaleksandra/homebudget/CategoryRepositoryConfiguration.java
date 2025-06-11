package pl.glozaaleksandra.homebudget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryRepositoryConfiguration {

  @Bean
  public CategoryRepository listBasedCategoryRepository(){
    return new ListBasedCategoryRepository();
  }
}
