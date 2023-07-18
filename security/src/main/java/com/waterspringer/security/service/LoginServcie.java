package com.waterspringer.security.service;


import com.waterspringer.commonutils.R;
import com.waterspringer.security.entity.User;

public interface LoginServcie {
    R login(User user);

    R logout();

}
