package pl.glozaaleksandra.homebudget.controllers.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.glozaaleksandra.homebudget.entities.CategoryEntity;
import pl.glozaaleksandra.homebudget.model.Category;
import pl.glozaaleksandra.homebudget.service.category.CategoryService;
import pl.glozaaleksandra.serializer.CategorySerializer;

import java.util.List;

@RestController
public class CategoryControllery {
    private CategoryService categoryService;

    public CategoryControllery(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAll() {
        List<CategoryEntity> categoryEntities = categoryService.findAll();
        List<Category> categories = categoryEntities.stream()
                .map(categoryEntity -> CategorySerializer.fromEntity(categoryEntity))
                .toList();
        return categories;
    }
}
