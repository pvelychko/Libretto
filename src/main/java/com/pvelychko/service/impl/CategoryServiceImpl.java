package com.pvelychko.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvelychko.domain.Category;
import com.pvelychko.domain.repository.CategoryRepository;
import com.pvelychko.service.CategoryService;

/**
 * Category service implementation class
 * @author pvelychko
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
   
    /**
     * Constructor
     * @param categoryRepository
     */
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Get category by id
     */
	@Override
	public Category getCategoryById(int id) {
		LOGGER.debug("Getting category={}", id);
//        return Optional.ofNullable(categoryRepository.findOne(id));
		return categoryRepository.findOne(id);
	}
    
    
    
}