package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createBook() {
        Book book = new Book();
        book.setTitle("Henna");
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();

    }

    @Test
    public void deleteBook() {
        Book book = new Book();
        book.setTitle("Henna2");
        bookRepository.save(book);

        bookRepository.deleteById(book.getId());

        Optional<Book> deletedBookOptional = bookRepository.findById(book.getId());
        assertThat(deletedBookOptional).isEmpty();

    }

    @Test
    public void findBook() {
        Book book = new Book();
        book.setTitle("Otsikko");
        book.setAuthor("Tekija");
        book.setIsbn("1234567890");
        bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());

        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("Otsikko");
        assertThat(foundBook.get().getAuthor()).isEqualTo("Tekija");
        assertThat(foundBook.get().getIsbn()).isEqualTo("1234567890");
    }
}
