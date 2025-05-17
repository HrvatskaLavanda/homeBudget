package pl.glozaaleksandra.homebudget;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void delete(String categoryName) {
        boolean found = false;
        Iterator<Category> categoryIterator = categories.iterator();
        while ((categoryIterator.hasNext())) {
            Category nextCategory = categoryIterator.next();
            if (nextCategory.getName().equals(categoryName)) {
                categoryIterator.remove();
                found = true;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Category not found. The category cannot be deleted");
        }
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
