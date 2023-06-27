package com.waterspringer.security.controller;


import com.waterspringer.commonutils.R;
import com.waterspringer.security.entity.User;
import com.waterspringer.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-06-26
 */
@RestController
@RequestMapping("/security/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public R getUser()
    {
        System.out.println("hello");
        return R.ok().message("hello");
    }


}

