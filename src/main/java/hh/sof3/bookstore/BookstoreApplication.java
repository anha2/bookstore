package hh.sof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("save some sample categories");
			Category category1 = new Category("Sci-Fi");
			categoryRepository.save(category1);

			Category category2 = new Category("Comic");
			categoryRepository.save(category2);

			log.info("save some sample books");
			bookRepository.save(new Book("Kiinalainen kissa", "Lumme Leena", 2008, "9789510343432", 12.00, category1));
			bookRepository.save(new Book("Aurora", "Sanaksenaho Pinja", 2024, "9789511468790", 24.95, category2));

			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());

			}

		};
	}

}
