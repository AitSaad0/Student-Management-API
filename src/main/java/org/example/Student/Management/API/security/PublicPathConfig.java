package org.example.Student.Management.API.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PublicPathConfig {

    @Bean
    public List<String> publicPath() {
       return  List.of(
                "api/v1/auth/**"
        );
    }
}
