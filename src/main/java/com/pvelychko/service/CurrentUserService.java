package com.pvelychko.service;

import com.pvelychko.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Integer userId);

}