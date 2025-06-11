package pl.glozaaleksandra.homebudget;

import pl.glozaaleksandra.homebudget.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.category.ListBasedCategoryRepository;

public class CategoryRepositoryStaticFactory {

    public static CategoryRepository categoryRepository() {
        return new ListBasedCategoryRepository();
    }
}
