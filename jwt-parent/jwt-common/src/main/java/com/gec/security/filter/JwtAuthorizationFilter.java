package com.gec.security.filter;

import com.gec.security.utils.JwtTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//检测用户访问资源的合法身份，看有没有登录
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         //首先获取请求头的token（Jwt）
        String tokenHeader =  request.getHeader("authorization");
        System.out.println("tokenHeader =" + tokenHeader);

        if (tokenHeader!=null && tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)){
            UsernamePasswordAuthenticationToken token = getAuthentication(tokenHeader);
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        //放行
        filterChain.doFilter(request,response);
    }

    //检测token的有效性
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader){
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX,"");
        String username = JwtTokenUtil.getProperties(token);
        System.out.println("username = "+ username);
        if (username!=null){
            return new UsernamePasswordAuthenticationToken(username,null,new ArrayList<>());
        }
        return null;
    }
}
