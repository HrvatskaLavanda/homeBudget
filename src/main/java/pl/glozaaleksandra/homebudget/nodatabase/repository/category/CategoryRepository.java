package pl.glozaaleksandra.homebudget.nodatabase.repository.category;

import pl.glozaaleksandra.homebudget.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();

    Category save(Category category);

    boolean delete(String categoryName);

    void update(Category category, String newName);

    Optional<Category> findByName(String categoryName);
}
