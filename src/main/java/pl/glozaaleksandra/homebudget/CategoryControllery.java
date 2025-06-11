package pl.glozaaleksandra.homebudget;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllery {
  private CategoryService categoryService;

  public CategoryControllery(@Autowired CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public List<Category> getAll(){
    return categoryService.findAll();
  }
}
