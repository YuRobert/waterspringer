package com.waterspringer.security.controller;

import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.security.entity.User;
import com.waterspringer.security.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Robert17
 * @create2023-07-12-13:08
 */

@RestController
@RequestMapping("/security/user")
public class LoginController
{
    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user)
    {
        return loginServcie.login(user);
    }

    @RequestMapping("/logout")
    public ResponseResult logout()
    {
        return loginServcie.logout();
    }
}
