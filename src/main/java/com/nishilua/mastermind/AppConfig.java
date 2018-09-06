package com.nishilua.mastermind;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AppConfig {

	/**
	 * Swagger UI configuration.
	 * Browse http://localhost:8081/swagger-ui.html
	 */
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Game v1")
                .apiInfo(apiInfo())
                .select()
                	.apis(RequestHandlerSelectors.basePackage("com.nishilua.mastermind.controller"))
                	.paths(regex("/v1/.*"))
                .build()
                .useDefaultResponseMessages(false);
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Mastermind REST API")
                .description("")
                .contact(new Contact("Alfonso Nishikawa", "http://www.nishilua.com/alfonso.nishikawa", ""))
                .license("GNU Affero General Public License v3.0")
                .licenseUrl("https://github.com/alfonsonishikawa/mastermind-rest/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
	
}