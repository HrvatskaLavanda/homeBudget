package pl.glozaaleksandra.homebudget;

import pl.glozaaleksandra.homebudget.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;

public class CategoryRepositoryFactoryImpl implements CategoryRepositoryFactory {
  @Override
  public CategoryRepository createCategoryRepository() {
    return new ListBasedCategoryRepository();
  }
}
