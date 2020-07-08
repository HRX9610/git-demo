package com.shopping.zuul;

import com.gec.security.compoment.RestAuthenticationEntryPoin;
import com.gec.security.compoment.RestAuthorizationHandler;
import com.gec.security.filter.JwtAuthorizationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //跨域访问
        http.cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/doLogin","/shopping-content-ms/**","/shopping-search-ms/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.addFilterBefore(new JwtAuthenticationFilter("/doLogin", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);//资源的拦截认证

        http.csrf().disable(); //防止post请求进不来

        //报错处理的组件
        http.exceptionHandling().accessDeniedHandler(new RestAuthorizationHandler())
                .authenticationEntryPoint(new RestAuthenticationEntryPoin());
    }
}
