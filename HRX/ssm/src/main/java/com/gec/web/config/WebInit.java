package com.gec.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

//相当于web.xml
public class WebInit implements WebApplicationInitializer {
    @Override  // alt+enter
    public void onStartup(ServletContext servletContext) throws ServletException {
        //指定spring的配置类
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMVCConfig.class);

        //中文编码处理过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        FilterRegistration.Dynamic charFilter = servletContext.addFilter("charFilter",encodingFilter);
        //第二个参数：false 表示当前过滤器编码方式优先
        charFilter.addMappingForUrlPatterns(null,false,"/*");

        //配置springmvc的前端控制器
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc",new DispatcherServlet(context));
        springmvc.addMapping("/"); //不带后缀的访问路径
        springmvc.setLoadOnStartup(1);
    }
}
