package com.waterspringer.security.controller;


import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
  //  @PreAuthorize("hasAuthority('test')")
    public ResponseResult getUser()
    {
        System.out.println("hello");
        return ResponseResult.ok().message("hello");
    }


}

