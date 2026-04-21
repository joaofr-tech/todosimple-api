package com.joaofrancisco.todosimple.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**"); // Onde permite o acesso, nesse caso coloquei qualquer coisa dps do /, ou seja, tudo (nao seguro)
    }
}
