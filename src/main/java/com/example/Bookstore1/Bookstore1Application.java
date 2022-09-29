package com.example.Bookstore1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;

@SpringBootApplication
public class Bookstore1Application {
	private static final Logger log = LoggerFactory.getLogger(Bookstore1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			log.info("save a couple of books");

			repository.save(new Book("Once", "Niklas", 1997, "978-3", 10.00));
			repository.save(new Book("Upon", "Kate", 1998, "977-5", 11.00));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			;
		};

	}
}
