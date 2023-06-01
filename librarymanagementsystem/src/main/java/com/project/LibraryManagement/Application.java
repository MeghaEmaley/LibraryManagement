package com.project.LibraryManagement;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.project.LibraryManagement.entity.Author;
import com.project.LibraryManagement.entity.Book;
import com.project.LibraryManagement.entity.Borrow;
import com.project.LibraryManagement.entity.Category;
import com.project.LibraryManagement.entity.Publisher;
import com.project.LibraryManagement.entity.Role;
import com.project.LibraryManagement.entity.User;
import com.project.LibraryManagement.repository.UserRepository;
import com.project.LibraryManagement.service.BookService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.LibraryManagement"})
public class Application {
	@Autowired
		private BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	private BookService bookService;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public CommandLineRunner initialCreate() {
		return (args) -> {

			var book = new Book("123", "Java ", "abc78", "Book description");
			book.addAuthors(new Author("john", "dummy description"));
			book.addCategories(new Category("Dummy categary"));
			book.addPublishers(new Publisher("Dummy publisher"));
			book.addBorrows(new Borrow("Dummy borrower"));
			bookService.createBook(book);

			var book1 = new Book("456", "Spring Microservices", "efg46", "Description1");
			book1.addAuthors(new Author("Max", "Test description1"));
			book1.addCategories(new Category("New category"));
			book1.addPublishers(new Publisher("publisher2"));
			book1.addBorrows(new Borrow("Dummy borrower2"));
			bookService.createBook(book1);

			var book2 = new Book("789", "Spring Boot", "hij89", "description2");
			book2.addAuthors(new Author("Leo", "Test description2"));
			book2.addCategories(new Category("Spring category"));
			book2.addPublishers(new Publisher("publisher3"));
			book2.addBorrows(new Borrow("Dummy borrower3"));
			bookService.createBook(book2);

			var user = new User("megha", "admin", "megha@gmail.com", passwordEncoder.encode("megha"),
					Arrays.asList(new Role("ROLE_ADMIN")));
			userRepository.save(user);

		};
	}
}
