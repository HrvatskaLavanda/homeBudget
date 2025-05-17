package pl.glozaaleksandra.homebudget;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    void save(Category category);

    void delete(String categoryName);

    void update(Category category, String newName);

}
