package com.example.Bookstore1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.Category;
import com.example.Bookstore1.domain.CategoryRepository;

@SpringBootApplication
public class Bookstore1Application {
	private static final Logger log = LoggerFactory.getLogger(Bookstore1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			log.info("save a couple of books");

			crepository.save(new Category("Horror"));
			crepository.save(new Category("Romantic"));
			crepository.save(new Category("Action"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Thriller"));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			;
		};

	}
}
