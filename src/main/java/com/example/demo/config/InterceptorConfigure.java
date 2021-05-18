package com.example.demo.config;

import com.example.demo.interceptor.ExecuteTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InterceptorConfigure implements WebMvcConfigurer {
    @Autowired
    private ExecuteTimeInterceptor executeTimeInterceptor;
    private static final List<String> URL_PATTERNS = Arrays.asList("/api/**");  //인터셉터가 동작 해야 될 요청 주소 mapping 목록

    //인터셉터 주소 세팅
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executeTimeInterceptor).addPathPatterns(URL_PATTERNS);
    }
}