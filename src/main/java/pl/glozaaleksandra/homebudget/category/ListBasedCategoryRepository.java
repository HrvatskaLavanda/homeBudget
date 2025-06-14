package pl.glozaaleksandra.homebudget.category;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
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
        Category categoryToBeDeleted = findByName(categoryName);
        categories.remove(categoryToBeDeleted);
    }

    @Override
    public void update(Category category, String newName) {
        Category foundCategory = findByName(category.getName());
        foundCategory.setName(newName);
    }


    @Override
    public Category findByName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category " + categoryName + " not found");
    }
}
