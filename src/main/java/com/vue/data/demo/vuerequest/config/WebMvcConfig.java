package com.vue.data.demo.vuerequest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //  addResourceHandler是指你想在url请求的路径
        // addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:d:/myImage/");
    }
}
