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

  public CategoryRepository getCategoryRepository() {
    return categoryRepository;
  }

  public List<Category> findAll() {
    return List.of();
}
}
