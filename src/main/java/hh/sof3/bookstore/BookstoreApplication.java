package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Kiinalainen kissa", "Lumme Leena", 2008, "9789510343432", 12.00);
			Book book2 = new Book("Aurora", "Sanaksenaho Pinja", 2024, "9789511468790", 24.95);

			bookRepository.save(book1);
			bookRepository.save(book2);

		};
	}

}
