package com.pvelychko.service.user;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
   
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

	@Override
	public Optional<Book> getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Book> getBookByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Book> getBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> getAllBooks() {
		LOGGER.debug("Getting all available books");
		return bookRepository.findAll(new Sort("name"));
	}

	@Override
	public Collection<Book> getAllAvailableBooks() {
		LOGGER.debug("Getting all available books");
		return bookRepository.findAll(new Sort("name"));
	}

	@Override
	public Collection<Book> getAllBorrowedBooks() {
		// TODO Auto-generated method stub
		return null;
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