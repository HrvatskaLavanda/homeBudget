package pl.glozaaleksandra.homebudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.glozaaleksandra.homebudget.category.Category;
import pl.glozaaleksandra.homebudget.category.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
  private CategoryRepository categoryRepository;

  public CategoryService(@Autowired CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository; // wstrzykniecie -> = (injection)
  }

  public CategoryRepository getCategoryRepository() {
    return categoryRepository;
  }

  public List<Category> findAll() {
    return List.of();
}
}
