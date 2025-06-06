package pl.glozaaleksandra.homebudget;

public class CategoryRepositoryFactoryImpl implements CategoryRepositoryFactory{
  @Override
  public CategoryRepository createCategoryRepository() {
    return new ListBasedCategoryRepository();
  }
}
