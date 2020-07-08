package com.gec.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.security.utils.CommonResult;
import com.gec.security.utils.JwtTokenUtil;
import com.gec.security.utils.UserDetailImpl;
import com.web.shopping.pojo.TbSeller;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//用户认证 回调
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(String url, AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(url);//指定用户认证的url
    }


    //用户认证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            //获取前端应用的json数据（用户名和密码）
            TbSeller user =  new ObjectMapper().readValue(request.getInputStream(), TbSeller.class);
            System.out.println("账号 ： "+ user.getSellerId());
            System.out.println("密码 ： "+ user.getPassword());

            //subject.login(token)
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getSellerId(),user.getPassword(),new ArrayList<>()));
        } catch (Exception e) {
            e.printStackTrace();
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null,null,new ArrayList<>()));
        }
    }

    //成功认证的回调方法，主要是返回一个有效的jwt的token
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
               response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取认证的主体信息
        UserDetailImpl userDetail = (UserDetailImpl) authResult.getPrincipal();
        //生成token
        String token = JwtTokenUtil.createToken("gec",userDetail.getUsername(),1800L);
        System.out.println(token);

        out.write(new ObjectMapper().writeValueAsString(CommonResult.success(JwtTokenUtil.TOKEN_PREFIX+token)));
        out.flush();
        out.close();
    }

    //认证失败的回调方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        System.out.println("failure exception:"+ failed.getMessage());
        out.write(new ObjectMapper().writeValueAsString(CommonResult.failed("登录失败")));
        out.flush();
        out.close();
    }
}
