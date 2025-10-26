package pl.glozaaleksandra.serializer;

import pl.glozaaleksandra.homebudget.entities.CategoryEntity;
import pl.glozaaleksandra.homebudget.model.Category;

public class CategorySerializer {
    public static Category fromEntity(CategoryEntity categoryEntity) {
        Category category = Category.builder()
                .categoryId(categoryEntity.getCategoryId())
                .name(categoryEntity.getCategoryName())
                .products(categoryEntity.getProducts())
                .build();
        return category;
    }
}
