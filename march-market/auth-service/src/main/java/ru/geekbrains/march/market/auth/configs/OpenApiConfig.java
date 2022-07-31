package ru.geekbrains.march.market.auth.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("GeekBrains - March Market - Продуктовый сервис")
                                .version("1")
                                .contact(
                                        new Contact()
                                                .name("Павел")
                                )
                );
    }
}