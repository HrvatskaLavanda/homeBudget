package pl.glozaaleksandra.homebudget.repository.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();

    void save(Category category);

    void delete(String categoryName);

    void update(Category category, String newName);

    Optional<Category> findByName(String categoryName);
}
