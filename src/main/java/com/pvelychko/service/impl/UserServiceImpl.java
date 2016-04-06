package com.pvelychko.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pvelychko.domain.User;
import com.pvelychko.domain.UserCreateForm;
import com.pvelychko.domain.repository.UserRepository;
import com.pvelychko.service.UserService;

/**
 * User service implementation class
 * @author pvelychko
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    /**
     * Constructor
     * @param userRepository
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get user by id
     */
    @Override
    public User getUserById(int id) {
        LOGGER.debug("Getting user={}", id);
//        return Optional.ofNullable(userRepository.findOne(id));
        return userRepository.findOne(id);
    }

    /**
     * Get user by email
     */
    @Override
    public User getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    /**
     * Get all users
     */
    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    /**
     * Create user
     */
    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }

}