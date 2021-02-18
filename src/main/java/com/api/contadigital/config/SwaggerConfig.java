package com.api.contadigital.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final String swaggerPath = "localhost:8080";

	@Bean
    public Docket allApi() {
			
		Set<String> protocols = new HashSet<>();
		protocols.add("http");
		protocols.add("https");
		
        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
        		.groupName("All")
        		.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.contadigital"))
                .paths(PathSelectors.any())
                .build()
                .protocols(protocols)
                .ignoredParameterTypes(ApiIgnore.class);
    }
	
	private ApiInfo apiInfo() {

        @SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "Conta Digital API",
                "Documentação da aplicação de gerenciamento de contas digitais",
                "1.0",
                "Terms of Service",
                new Contact("Kenneth de Oliveira Soares", "https://www.linkedin.com/in/kenneth-de-oliveira",
                        "kennetholiveira2015@gmail.com"),
                "Apache License 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.txt", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
	
}
