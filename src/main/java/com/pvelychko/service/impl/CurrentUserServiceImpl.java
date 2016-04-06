package com.pvelychko.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pvelychko.domain.CurrentUser;
import com.pvelychko.domain.Role;
import com.pvelychko.service.CurrentUserService;

/**
 * Current user service implementation class 
 * @author pvelychko
 *
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsServiceImpl.class);

    /**
     * Check if the specified user can access another user by id
     */
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Integer userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}