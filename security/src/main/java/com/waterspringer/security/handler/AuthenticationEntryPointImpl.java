package com.waterspringer.security.handler;

import com.alibaba.fastjson.JSON;
import com.waterspringer.commonutils.R;
import com.waterspringer.security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Robert17
 * @create2023-07-18-9:38
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException
    {
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(R.error().code(HttpStatus.FORBIDDEN.value()).message("认证失败，请重新登陆")));
    }
}
