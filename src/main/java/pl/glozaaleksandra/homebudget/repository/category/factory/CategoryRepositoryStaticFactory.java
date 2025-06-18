package pl.glozaaleksandra.homebudget.repository.category.factory;

import pl.glozaaleksandra.homebudget.repository.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.repository.category.ListBasedCategoryRepository;

public class CategoryRepositoryStaticFactory {

    public static CategoryRepository categoryRepository() {
        return new ListBasedCategoryRepository();
    }
}
