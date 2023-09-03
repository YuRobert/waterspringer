package com.waterspringer.security.utils;

import com.waterspringer.security.entity.LoginUser;
import com.waterspringer.security.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Robert17
 * @create2023-07-20-10:04
 */
@Component
public class SecurityUtils
{
    public User getLoginUserInfo()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        User user = loginUser.getUser();
        return user;
    }
}
