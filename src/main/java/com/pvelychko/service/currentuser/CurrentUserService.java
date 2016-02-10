package com.pvelychko.service.currentuser;

import com.pvelychko.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Integer userId);

}