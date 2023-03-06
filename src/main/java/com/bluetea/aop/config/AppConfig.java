package com.bluetea.aop.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 过时方法
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@Component
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //  configurer.setUseRegisteredSuffixPatternMatch("api", o -> true);
    }

}
