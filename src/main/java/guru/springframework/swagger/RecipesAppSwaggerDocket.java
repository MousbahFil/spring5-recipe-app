package guru.springframework.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.any;

@Configuration
@EnableSwagger2
public class RecipesAppSwaggerDocket {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(any())
                    .paths(PathSelectors.any())
                    .build();
        }

}