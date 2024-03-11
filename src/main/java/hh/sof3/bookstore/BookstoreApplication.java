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
import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {

			log.info("save some sample categories");
			Category category1 = new Category("Sci-Fi");
			categoryRepository.save(category1);

			Category category2 = new Category("Comic");
			categoryRepository.save(category2);

			log.info("save some sample books");
			bookRepository.save(new Book("Kiinalainen kissa", "Lumme Leena", 2008, "9789510343432", 12.00, category1));
			bookRepository.save(new Book("Aurora", "Sanaksenaho Pinja", 2024, "9789511468790", 24.95, category2));

			User user1 = new User("user", "$2a$10$KHovR1IP2sqGbxpvjLc2qe19OeUxKLbON6.eW4yG/XgIMphWwrNlO",
					"user1@mai.mail", "USER");
			User user2 = new User("admin", "$2a$10$U0E9PbtSqVoPvHmE5UicYesiPEGI2G9S.oO0zZipeJxkTaTr/fRoG",
					"user2@mai.mail", "ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());

			}

		};
	}

}
