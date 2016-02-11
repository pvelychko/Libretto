package com.pvelychko.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pvelychko.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findOneByEmail(String email);
    
}