package com.pvelychko.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.domain.User;
import com.pvelychko.domain.repository.BookRepository;
import com.pvelychko.service.BookService;

/**
 * Book service implementation class
 * @author pvelychko
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    
    /**
     * Constructor
     * @param bookRepository
     */
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Get book by id
     */
	@Override
	public Book getBookById(int id) {
		LOGGER.debug("Getting book={}", id);
//        return Optional.ofNullable(bookRepository.findOne(id));
		return bookRepository.findOne(id);
	}

	/**
	 * Get book by name
	 */
	@Override
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get book by author
	 */
	@Override
	public Book getBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get all books
	 */
	@Override
	public Collection<Book> getAllBooks() {
		LOGGER.debug("Getting all available books");
		return bookRepository.findAll(new Sort("name"));
	}

	/**
	 * Get all available books
	 */
	@Override
	public Collection<Book> getAvailableBooks() {
		LOGGER.debug("Getting all available books");
		return bookRepository.findAll(new Sort("name"));
	}

	/**
	 * Get all borrowed books
	 */
	@Override
	public Collection<Book> getBorrowedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get list of user books
	 */
	@Override
	public Collection<Book> getUserBooks(User student) {
		LOGGER.debug("Getting all books for user={}", student);
        return bookRepository.findByStudent(student);
	}

	/**
	 * Borrow book by user
	 */
	@Override
	public Book borrowBook(Book book, User student) {
		LOGGER.debug("Getting all books for user={}", student);
		
		book.setStudent(student);

		return bookRepository.save(book);
	}

	/**
	 * Return book
	 */
	@Override
	public Book returnBook(Book book) {
		book.setStudent(null);
		return bookRepository.save(book);
	}

	/**
	 * Get categories list
	 */
	@Override
	public Collection<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		for (Book book: bookRepository.findAll()) {
			Category category = book.getCategory();
			if (!categories.contains(category)) {
				categories.add(category);
			}
		}
		return categories;
	}

	/**
	 * Get category books
	 */
	@Override
	public Collection<Book> getBookByCategory(Category category) {
		return bookRepository.findByCategory(category);
	}
	
//    @Override
//    public Optional<User> getUserById(int id) {
//        LOGGER.debug("Getting user={}", id);
//        return Optional.ofNullable(userRepository.findOne(id));
//    }
//
//    @Override
//    public Optional<User> getUserByEmail(String email) {
//        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
//        return userRepository.findOneByEmail(email);
//    }
//
//    @Override
//    public Collection<User> getAllUsers() {
//        LOGGER.debug("Getting all users");
//        return userRepository.findAll(new Sort("email"));
//    }
//
//    @Override
//    public User create(UserCreateForm form) {
//        User user = new User();
//        user.setEmail(form.getEmail());
//        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
//        user.setRole(form.getRole());
//        return userRepository.save(user);
//    }

}