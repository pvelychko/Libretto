package com.pvelychko.service;

import java.util.Collection;

import com.pvelychko.domain.User;
import com.pvelychko.domain.UserCreateForm;

/**
 * User service interface
 * @author pvelychko
 *
 */
public interface UserService {

    User getUserById(int id);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}