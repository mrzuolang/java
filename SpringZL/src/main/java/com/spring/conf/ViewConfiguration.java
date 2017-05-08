package com.spring.conf;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
 
@Configuration
public class ViewConfiguration {
 
    @Bean
    public ViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver viewResolver;
        viewResolver = new UrlBasedViewResolver();
        viewResolver.setOrder(2);
        viewResolver.setPrefix("/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        // for debug envirment
        viewResolver.setCache(false);
        return viewResolver;
    }
}