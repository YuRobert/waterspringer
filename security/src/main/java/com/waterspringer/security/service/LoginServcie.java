package com.waterspringer.security.service;


import com.waterspringer.security.entity.ResponseResult;
import com.waterspringer.security.entity.User;

public interface LoginServcie {
    ResponseResult login(User user);

    ResponseResult logout();

}
