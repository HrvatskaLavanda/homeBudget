package pl.glozaaleksandra.homebudget.repository.category;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ListBasedCategoryRepository implements CategoryRepository {

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category save(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public boolean delete(String categoryName) {
        Optional<Category> categoryToBeDeleted = findByName(categoryName);
        categories.remove(categoryToBeDeleted);
    }

    @Override
    public void update(Category category, String newName) {
        Category foundCategory = findByName(category.getName());
        foundCategory.setName(newName);
    }


    @Override
    public Optional<Category> findByName(String categoryName) {
//        for (Category category : categories) {
//            if (category.getName().equals(categoryName)) {
//                return category;
//            }
//        }

        return categories.stream()
            .filter(category -> category.getName().equals(categoryName))
            .findFirst();
//            .orElseThrow(() -> new IllegalArgumentException("Category " + categoryName + " not found"));

//        if (categoryOptional.isEmpty()){
//            throw new IllegalArgumentException("Category " + categoryName + " not found");
//        } else {
//            return categoryOptional.get();
//        }


    }
}
