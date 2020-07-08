package com.gec.security.compoment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.security.utils.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//未登录或token失效时的报错接口
@Component
public class RestAuthenticationEntryPoin implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write(new ObjectMapper().writeValueAsString(CommonResult.unauthorized(e.getMessage())));
        out.flush();
        out.close();

    }
}
