package enoca.task.enocatask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value(
            "Base URL :" +
            "<a href =\"http://127.0.0.1:8080/api/v1/\"> http://127.0.0.1:8080/api/v1/ </a>") String description,
                                 @Value("${application-version}") String version) {
        return new OpenAPI()
                .info(new Info().title("Company Employers API")
                        .version(version)
                        .description(description)
                        .license(new License().name("Company Employee  API Licence")));
    }
}