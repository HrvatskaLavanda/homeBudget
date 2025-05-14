package pl.glozaaleksandra.homebudget;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    void save(Category category);

    void delete(Category categoryToBeRemoved);

void update(Category category, String newName);

}
