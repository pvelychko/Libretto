package com.pvelychko.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pvelychko.domain.Book;
import com.pvelychko.domain.Category;
import com.pvelychko.domain.User;
import com.pvelychko.domain.UserCreateForm;
import com.pvelychko.domain.validator.UserCreateFormValidator;
import com.pvelychko.service.BookService;
import com.pvelychko.service.CategoryService;
import com.pvelychko.service.UserService;

/**
 * User controller class
 * @author pvelychko
 *
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private final CategoryService categoryService;
    private final BookService bookService;

    /**
     * Constructor
     * @param userService
     * @param userCreateFormValidator
     * @param categoryService
     * @param bookService
     */
    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator, CategoryService categoryService, BookService bookService) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    /**
     * Initialization bundler
     * @param binder
     */
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    /**
     * Get user page by id
     * @param id
     * @param model
     * @return view
     */
    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Integer id, Model model) {
        LOGGER.debug("Getting user page for user={}", id);
        
        User student = userService.getUserById(id);
//        .orElseThrow(() -> 
//        		new NoSuchElementException(String.format("User=%s not found", id)));
        
        List<Book> books = new ArrayList<>();
        books.addAll(bookService.getUserBooks(student));
        model.addAttribute("books", books);
        
        List<Category> userBookCategories = new ArrayList<>();
        for (Book book: books) {
			if (!userBookCategories.contains(book.getCategory())) {
				userBookCategories.add(book.getCategory());
			}
		}
        model.addAttribute("categories", userBookCategories);
        
        return new ModelAndView("user", "user", student);
    }

    /**
     * Get the category info for the specified user
     * @param id
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping("/user/{id}/category/{categoryId}")
    public ModelAndView getUserCategoryPage(@PathVariable Integer id, @PathVariable Integer categoryId, Model model) {
        LOGGER.debug("Getting books page for category={}", id);
        
        User student = userService.getUserById(id);
//        .orElseThrow(() -> 
//        	new NoSuchElementException(String.format("User=%s not found", id)));
        
        Category category = categoryService.getCategoryById(categoryId);
//        		.orElseThrow(() -> 
//        		new NoSuchElementException(String.format("Category=%s not found", categoryId)));
        
        model.addAttribute("currentCategory", category);
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        model.addAttribute("categories", categories);
        
        model.addAttribute("currentBook", null);
        
        List<Book> books = new ArrayList<>();
        for (Book book: bookService.getUserBooks(student)) {
			if (book.getCategory().equals(category)) {
				books.add(book);
			}
		}
        
        model.addAttribute("books", books);
        
        return new ModelAndView("user", "user", student);
    }
    
    /**
     * Get the book info for the specified user
     * @param id
     * @param categoryId
     * @param model
     * @return
     */
    @RequestMapping("/user/{id}/book/{bookId}")
    public ModelAndView getUserBookPage(@PathVariable Integer id, @PathVariable Integer bookId, Model model) {
        LOGGER.debug("Getting page for book={}", id);
        
        Book book = bookService.getBookById(bookId);
//        		.orElseThrow(() -> 
//        		new NoSuchElementException(String.format("Book=%s not found", bookId)));
        
        User student = userService.getUserById(id);
//        		.orElseThrow(() -> 
//    		new NoSuchElementException(String.format("User=%s not found", id)));
	    
	    model.addAttribute("currentCategory", book.getCategory());
	    model.addAttribute("currentBook", book);
	    List<Book> books = new ArrayList<>();
	    books.add(book);
	    model.addAttribute("books", books);
        
	    List<Category> categories = new ArrayList<>();
        categories.add(book.getCategory());
        model.addAttribute("categories", categories);
	    
	    return new ModelAndView("user", "user", student);
    }
    
//    @RequestMapping("/user/{id}/category/{categoryId}/book/{bookId}")
//    public ModelAndView getUserCategoryBookPage(@PathVariable Integer id, @PathVariable Integer bookId, Model model) {
//        LOGGER.debug("Getting page for book={}", id);
//        
//        Book book = bookService.getBookById(id).orElseThrow(() -> 
//        		new NoSuchElementException(String.format("Book=%s not found", id)));
//        
//        User student = userService.getUserById(id).orElseThrow(() -> 
//    		new NoSuchElementException(String.format("User=%s not found", id)));
//	    
//	    model.addAttribute("currentCategory", book.getCategory());
//	    model.addAttribute("currentBook", book);
//	    List<Book> books = new ArrayList<>();
//	    books.add(book);
//	    model.addAttribute("books", books);
//        
//	    return new ModelAndView("user", "user", student);
//    }
    
    /**
     * Get user creation page
     * @return view
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    /**
     * Create new user
     * @param form
     * @param bindingResult
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "user_create";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        // ok, redirect
        return "redirect:/users";
    }
    
    /**
     * Borrow the specified book to user 
     * @param id
     * @param bookId
     * @return view
     */
    @RequestMapping("/user/{id}/book/{bookId}/borrow")
	public String borrowBook(@PathVariable Integer id, @PathVariable("bookId") Integer bookId) {
    	User student = userService.getUserById(id);
//    	.orElseThrow(() -> 
//    		new NoSuchElementException(String.format("User=%s not found", id)));
    	Book book = bookService.getBookById(bookId);
//    	.orElseThrow(() -> 
//			new NoSuchElementException(String.format("Book=%s not found", bookId)));
		bookService.borrowBook(book, student);
		return "redirect:/";
	}
    
    /**
     * Return the specified book
     * @param id
     * @param bookId
     * @return view
     */
    @RequestMapping("/user/{id}/book/{bookId}/return")
	public String returnBook(@PathVariable Integer id, @PathVariable("bookId") Integer bookId) {
    	Book book = bookService.getBookById(bookId);
//    	.orElseThrow(() -> 
//			new NoSuchElementException(String.format("Book=%s not found", bookId)));
		bookService.returnBook(book);
		return "redirect:/";
	}
    
    /**
     * Borrow the specified book to user from profile
     * @param id
     * @param bookId
     * @return view
     */
    @RequestMapping("/user/{id}/profile/book/{bookId}/borrow")
	public String borrowBookFromProfile(@PathVariable Integer id, @PathVariable("bookId") Integer bookId) {
    	User student = userService.getUserById(id);
//    			;.orElseThrow(() -> 
//    		new NoSuchElementException(String.format("User=%s not found", id)));
    	Book book = bookService.getBookById(bookId);
//    	.orElseThrow(() -> 
//			new NoSuchElementException(String.format("Book=%s not found", bookId)));
		bookService.borrowBook(book, student);
		return "redirect:/user/{id}";
	}
    
    /**
     * Return the specified book from profile
     * @param id
     * @param bookId
     * @return view
     */
    @RequestMapping("/user/{id}/profile/book/{bookId}/return")
	public String returnBookFromProfile(@PathVariable Integer id, @PathVariable("bookId") Integer bookId) {
    	Book book = bookService.getBookById(bookId);
//    	.orElseThrow(() -> 
//			new NoSuchElementException(String.format("Book=%s not found", bookId)));
    	bookService.returnBook(book);
		return "redirect:/user/{id}";
	}

}