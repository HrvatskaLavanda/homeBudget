package pl.glozaaleksandra.homebudget.service.category;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.glozaaleksandra.homebudget.repository.category.Category;
import pl.glozaaleksandra.homebudget.repository.category.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository; // wstrzykniecie -> = (injection)
    }

    public List<Category> findAll() {
        // zwracasz wszystkie z repo
        return categoryRepository.findAll();
    }

    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("Category " + categoryName + " not found"));
    }

    public Category saveNewCategory() {
        // dodać kategorie do repo
        // categoryRepository.save();
        // zwrocic
        return Category.builder().build();
    }
}
