package com.pvelychko.service;

import com.pvelychko.domain.CurrentUser;

/**
 * Current user service interface
 * @author pvelychko
 *
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Integer userId);

}