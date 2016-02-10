package com.pvelychko.service.user;

import java.util.Collection;
import java.util.Optional;

import com.pvelychko.domain.User;
import com.pvelychko.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(int id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}