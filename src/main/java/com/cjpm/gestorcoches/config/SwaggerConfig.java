package com.cjpm.gestorcoches.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){

        return new OpenAPI()
                .info(new Info().title("Spring Boot Gestor Coche API REST")
                        .description("Gestor de Coches REST DOCS")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Carlos Jesús Pérez Márquez")
                                .email("carlos@prueba.com").url("http://localhost:8080/swagger-ui/index.html#/")));

    }

}

