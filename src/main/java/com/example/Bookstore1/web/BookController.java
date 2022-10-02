package com.example.Bookstore1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@GetMapping(value = "/booklist")
	public String booklist(Model model) {
		model.addAttribute("list", repository.findAll());
		return "booklist";
	}

	// delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}

	// add book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	// edit book
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("edit", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}

	// save book
	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";

	}

}
