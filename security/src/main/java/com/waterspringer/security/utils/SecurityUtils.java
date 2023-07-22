package com.waterspringer.security.utils;

import com.waterspringer.security.entity.LoginUser;
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

    public LoginUser getLoginUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser;
    }
}
