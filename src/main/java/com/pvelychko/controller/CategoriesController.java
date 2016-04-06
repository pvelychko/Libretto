package com.pvelychko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pvelychko.service.CategoryService;

/**
 * Categories controller
 * @author pvelychko
 *
 */
@Controller
public class CategoriesController {

	private final CategoryService categoryService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    /**
     * Constructor
     * @param categoryService
     */
    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
}