package pl.glozaaleksandra.homebudget.repository.category.factory;

import pl.glozaaleksandra.homebudget.repository.category.CategoryRepository;

public interface CategoryRepositoryFactory {
  public CategoryRepository createCategoryRepository();
}
