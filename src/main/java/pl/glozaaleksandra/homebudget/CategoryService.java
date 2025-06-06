package pl.glozaaleksandra.homebudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private CategoryRepository categoryRepository;

  public CategoryService(@Autowired CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository; // wstrzykniecie -> = (injection)
  }

  public CategoryRepository getCategoryRepository() {
    return categoryRepository;
  }
}
