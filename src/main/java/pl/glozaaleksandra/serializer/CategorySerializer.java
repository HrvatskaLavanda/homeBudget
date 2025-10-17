package pl.glozaaleksandra.serializer;

import pl.glozaaleksandra.homebudget.entities.CategoryEntity;
import pl.glozaaleksandra.homebudget.model.Category;

public class CategorySerializer {
    public static Category fromEntity(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setCategoryId(categoryEntity.getCategoryId());
        category.setName(categoryEntity.getCategoryName());
        category.setProducts(categoryEntity.getProducts());
        return category;
    }
}
