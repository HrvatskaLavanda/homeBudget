package pl.glozaaleksandra.homebudget.service.category;

import org.springframework.stereotype.Service;
import pl.glozaaleksandra.homebudget.entities.CategoryEntity;
import pl.glozaaleksandra.homebudget.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository; // wstrzykniecie -> = (injection)
    }

    public List<CategoryEntity> findAll() {
        // zwracasz wszystkie z repo
        return categoryRepository.findAll();
    }

    public CategoryEntity findByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("Category " + categoryName + " not found"));
    }

    public CategoryEntity saveNewCategory(String categoryName) {
        //pusty Optional, lub niepusty Optional
//        categoryRepository.findByName(categoryName)
//                .orElseGet(() -> categoryRepository.save(new Category(categoryName))); //.orElse zawsze się wykona, dlatego nie poszedł test nr 2

        Optional<CategoryEntity> possiblyFoundCategory = categoryRepository.findByCategoryName(categoryName);
        if (possiblyFoundCategory.isPresent()) {
            return possiblyFoundCategory.get();
        } else {
            CategoryEntity category = CategoryEntity.builder()
                    .categoryName(categoryName)
                    .build();
            CategoryEntity newCategory = categoryRepository.save(category);
            return newCategory;
        }
    }


    // TODO - uzupełnij tą metodę w taki sposób aby:
    //  - jeśli kategoria o takiej nazwie już istneije - nie zapisuj nowej, tylko zwróć istniejącą
    //  - jeśli nie istnieje - stwórz
    // Sprawdzisz, czy dobrze uzupełniłaś metodę odpalając testy. Link z instrukcją jak to zrobić znajdziesz
    // na discordzie.
}

