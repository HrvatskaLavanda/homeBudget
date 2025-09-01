package pl.glozaaleksandra.homebudget.nodatabase.repository.category.factory;

import pl.glozaaleksandra.homebudget.nodatabase.repository.category.CategoryRepository;
import pl.glozaaleksandra.homebudget.nodatabase.repository.category.ListBasedCategoryRepository;

public class CategoryRepositoryStaticFactory {

    public static CategoryRepository categoryRepository() {
        return new ListBasedCategoryRepository();
    }
}
