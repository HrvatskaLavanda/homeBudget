package pl.glozaaleksandra.homebudget.repository.category.factory;

import pl.glozaaleksandra.homebudget.repository.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.repository.category.ListBasedCategoryRepository;

public class CategoryRepositoryFactoryImpl implements CategoryRepositoryFactory {
  @Override
  public CategoryRepository createCategoryRepository() {
    return new ListBasedCategoryRepository();
  }
}
