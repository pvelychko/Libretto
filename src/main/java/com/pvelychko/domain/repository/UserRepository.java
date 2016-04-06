package com.pvelychko.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvelychko.domain.User;

/**
 * User repository interface
 * @author pvelychko
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByEmail(String email);
    
}