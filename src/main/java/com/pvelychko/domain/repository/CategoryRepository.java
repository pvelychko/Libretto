package com.pvelychko.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.Category;

/**
 * Category repository interface
 * @author pvelychko
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}