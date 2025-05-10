package pl.glozaaleksandra.homebudget;

import java.util.ArrayList;
import java.util.List;

public class ListBasedCategoryRepository implements CategoryRepository {

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void save(Category category) {
        categories.add(category);
    }
}
