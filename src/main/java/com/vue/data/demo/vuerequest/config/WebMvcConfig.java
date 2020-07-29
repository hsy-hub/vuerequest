package com.vue.data.demo.vuerequest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author hsy
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
/**
 * extends WebMvcConfigurationSupport
 */
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //  addResourceHandler是指你想在url请求的路径
        // addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:d:/myImage/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/login",
                "/imagesUpload",
                "/upload/**",
                "/myImage",
                "/updatePwd"
        );
    }
}
