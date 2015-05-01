package br.com.while42.treinofitness.controller.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("homeNotSignedIn");
        registry.addViewController("/").setViewName("homeNotSignedIn");
        registry.addViewController("/login").setViewName("login");
    }
}