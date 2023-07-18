package com.waterspringer.security.service.impl;

import com.waterspringer.commonutils.R;
import com.waterspringer.security.entity.LoginUser;
import com.waterspringer.security.entity.User;
import com.waterspringer.security.service.LoginServcie;
import com.waterspringer.security.utils.JwtUtil;
import com.waterspringer.security.utils.RedisCache;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Robert17
 * @create2023-07-12-13:20
 */
@Service
public class LoginServiceImpl implements LoginServcie
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public R login(User user)
    {
        //AuthenticationManager进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);


        //如果认证没通过给出对应的提示
        if(Objects.isNull(authenticate))
        {
            throw new RuntimeException("登陆失败");
        }
        //如果没通过，给出userid生成一个jwt jwt存入
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把完整用户信息存入redis userid作为key
        redisCache.setCacheObject("login:"+userId,loginUser);
        return R.ok().data("jwt",jwt);
    }

    @Override
    public R logout()
    {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getUserId();
        redisCache.deleteObject("login:"+userId);
        return R.ok();
    }
}
