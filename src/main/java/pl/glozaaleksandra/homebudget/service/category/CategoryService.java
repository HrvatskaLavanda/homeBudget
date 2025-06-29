package pl.glozaaleksandra.homebudget.service.category;

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

    public Category saveNewCategory(String food) {
        return categoryRepository.findByName(food)
                .orElse(categoryRepository.save(new Category(food)));


        // TODO - uzupełnij tą metodę w taki sposób aby:
        //  - jeśli kategoria o takiej nazwie już istneije - nie zapisuj nowej, tylko zwróć istniejącą
        //  - jeśli nie istnieje - stwórz
        // Sprawdzisz, czy dobrze uzupełniłaś metodę odpalając testy. Link z instrukcją jak to zrobić znajdziesz
        // na discordzie.
    }
}
