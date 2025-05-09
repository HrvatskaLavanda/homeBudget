package pl.glozaaleksandra.homebudget;

import java.util.List;

public class ListBasedCategoryRepository implements CategoryRepository {

    private List<Category> categories;

    @Override
    public List<Category> findAll() {
        return categories;
    }
}
