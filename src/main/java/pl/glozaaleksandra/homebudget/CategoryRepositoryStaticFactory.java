package pl.glozaaleksandra.homebudget;

public class CategoryRepositoryStaticFactory {

  public static CategoryRepository categoryRepository(){
    return new ListBasedCategoryRepository();
  }
}
