package pl.glozaaleksandra.homebudget.nodatabase.repository.category.factory;

import pl.glozaaleksandra.homebudget.nodatabase.repository.category.CategoryRepository;

public interface CategoryRepositoryFactory {
  public CategoryRepository createCategoryRepository();
}
