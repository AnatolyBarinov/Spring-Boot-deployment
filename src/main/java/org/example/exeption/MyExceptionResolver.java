package org.example.exeption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MyExceptionResolver {

    @Bean
    public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        Properties exceptionMappings = new Properties();
        exceptionMappings.put("InvalidCredentials", "error/invalidCredentials");
        exceptionMappings.put("UnauthorizedUser", "error/unauthorizedUser");

        exceptionResolver.setExceptionMappings(exceptionMappings);
        return exceptionResolver;
    }
}