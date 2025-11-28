package ru.car.api.nsi.cfg;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerCfg {
    @Bean
    public OpenAPI contractOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Contract Microservice API")
                        .description("API")
                        .version("1.0.0"));

    }
}
