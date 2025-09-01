package pl.glozaaleksandra.homebudget.nodatabase.repository.category.factory;

import pl.glozaaleksandra.homebudget.nodatabase.repository.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.nodatabase.repository.category.ListBasedCategoryRepository;

public class CategoryRepositoryFactoryImpl implements CategoryRepositoryFactory {
  @Override
  public CategoryRepository createCategoryRepository() {
    return new ListBasedCategoryRepository();
  }
}
