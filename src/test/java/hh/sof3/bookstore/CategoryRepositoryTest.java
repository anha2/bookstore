package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setName("Ohjelmointi");
        categoryRepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();

    }

    @Test
    public void deleteCategory() {
        Category category = new Category();
        category.setName("Ohjelmointi");
        categoryRepository.save(category);

        categoryRepository.deleteById(category.getCategoryid());

        Optional<Category> deletedCategoryOptional = categoryRepository.findById(category.getCategoryid());
        assertThat(deletedCategoryOptional).isEmpty();

    }

    @Test
    public void findCategory() {
        Category category = new Category();
        category.setName("Ohjelmointi");
        categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findById(category.getCategoryid());

        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Ohjelmointi");
    }

}
