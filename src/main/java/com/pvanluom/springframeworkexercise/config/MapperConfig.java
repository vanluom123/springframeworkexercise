package com.pvanluom.springframeworkexercise.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper mapper() {
        var map = new ModelMapper();
        return new ModelMapper();
    }
}
