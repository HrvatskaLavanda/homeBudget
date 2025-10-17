package pl.glozaaleksandra.homebudget.controllers.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.glozaaleksandra.homebudget.model.Category;
import pl.glozaaleksandra.homebudget.service.category.CategoryService;

import java.util.List;

@RestController
public class CategoryControllery {
  private CategoryService categoryService;

  public CategoryControllery(@Autowired CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public List<Category> getAll() {
    return categoryService.findAll();
  }
}
