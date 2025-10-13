package pl.glozaaleksandra.homebudget.service.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.glozaaleksandra.homebudget.entities.CategoryEntity;
import pl.glozaaleksandra.homebudget.repository.CategoryRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryEntity category;

    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void shouldAddNewCategory() {
        // given
        CategoryEntity expected = CategoryEntity.builder()
                .categoryName("Food")
                .build();
        when(categoryRepository.findByCategoryName(eq("Food"))).thenReturn(Optional.empty());
        when(categoryRepository.save(eq(expected))).thenReturn(expected);

        //when
        CategoryEntity newCategory = categoryService.saveNewCategory("Food");

        //then
        verify(categoryRepository).save(eq(expected));
        Assertions.assertEquals(expected, newCategory, "saved new category had different data than expected! "
                + "Did you save a new category with this exactly name?");
    }


    @Test
    public void shouldReturnAlreadyExistingCategory() {
        // given
        CategoryEntity expected = CategoryEntity.builder()
                .categoryName("Food")
                .build();
        when(categoryRepository.findByCategoryName(eq("Food"))).thenReturn(Optional.of(category));

        //when
        CategoryEntity shouldBeTheSame = categoryService.saveNewCategory("Food");

        //then
        verify(categoryRepository, times(0)).save(eq(expected));
        Assertions.assertEquals(category, shouldBeTheSame, "Existing category was not returned but a new one was returned.");
    }

}