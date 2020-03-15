package com.zte.config;

import com.zte.intercepter.MyIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Autowired
    private MyIntercepter myIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        assert registry != null;
        registry.addInterceptor(myIntercepter)
                .excludePathPatterns("/**")
                //.addPathPatterns("/**")
                .excludePathPatterns("/testvue")
                .excludePathPatterns("*.html");
    }
}
