package pl.glozaaleksandra.homebudget;

import pl.glozaaleksandra.homebudget.category.CategoryRepository;

public interface CategoryRepositoryFactory {
  public CategoryRepository createCategoryRepository();
}
