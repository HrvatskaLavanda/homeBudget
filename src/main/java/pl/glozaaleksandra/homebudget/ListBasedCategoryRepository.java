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

    @Override
    public void delete(Category categoryToBeRemoved) {
        categories.remove(categoryToBeRemoved);
    }

    @Override
    public void update(Category category, String newName) {
        if (category == null) {
            throw new IllegalArgumentException("Category not found. The name cannot be changed");
        }
        for (Category c : categories) {
            if (c.equals(category)) {
                c.setName(newName);
            }
        }
    }
}
