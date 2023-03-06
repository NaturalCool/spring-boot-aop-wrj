package com.bluetea.aop.config;

import com.bluetea.aop.interceptor.LoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 拦截器
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@Component
public class MyConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public MyConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                // 拦截所有请求
                .addPathPatterns("/**")
                // 排除不拦截的 url
                .excludePathPatterns("/user/login", "/user/reg", "/user/index")
                .excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.css");
    }
}
