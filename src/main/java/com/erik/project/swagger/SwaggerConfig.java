package com.erik.project.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration 
@EnableSwagger2
public class SwaggerConfig {

	
	
	@Bean                 
	public Docket api() {

		Docket docketASerRetornado = new Docket( DocumentationType.SWAGGER_2 );
		
		
		return docketASerRetornado.select()                                       
				                  .apis(RequestHandlerSelectors.basePackage("com.erik.project.controllers"))
				                  .paths(PathSelectors.any()).build()
				                  .apiInfo( apiInfo() );
	}

	
	
	private ApiInfo apiInfo() {
		
		
		//Aqui eu defino o texto que vou querer que aparece la interface visual do Swagger.
	    String  title             = " API DOCUMENTATION - Project IUGO-Erik-Test";
	    String  description       = "Erik's documentation made with Swagger - List of application endpoints in detail";
        String  version           = "1.0";
        String  termsOfServiceUrl = "https://iugo-erik-test.herokuapp.com";
        String  license           = "License free";
        String  licenseUrl        = "https://iugo-erik-test.herokuapp.com";
        Contact contact           = new Contact("Erik Lima", "https://www.linkedin.com/in/eriklima", "https://iugo-erik-test.herokuapp.com");

        
		ApiInfo apiInfo = new ApiInfo( title, description, version, termsOfServiceUrl, contact, license, licenseUrl );

		return apiInfo;		
		
	}

}