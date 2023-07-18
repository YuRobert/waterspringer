package com.waterspringer.security.handler;

import com.alibaba.fastjson.JSON;
import com.waterspringer.commonutils.R;
import com.waterspringer.security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Robert17
 * @create2023-07-18-9:35
 */
@Component
public class AccessDeniedHandlerImpl  implements AccessDeniedHandler
{

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException
    {
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(R.error().code(HttpStatus.UNAUTHORIZED.value()).message("权限不足")));
    }
}
