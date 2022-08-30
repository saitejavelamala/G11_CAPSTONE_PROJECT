package com.wipro.doconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;	
/*@Author:Saiteja Velamala
 * Modified Date: 26-08-2022
 * Description: Swagger API
 */
@Configuration
public class SwaggerConfig
{
	@Bean
	public Docket libraryApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("Library_API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wipro.doconnect.controller"))
				.build();
	}
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("Library API")
				.description("Library API reference for developers")
				.termsOfServiceUrl("http://fakelibrary.com")
				.contact(new Contact("Library API", "http://fakelibrary.com", "fakelibrary@gmail.com"))
				.license("Library Licence")
				.licenseUrl("http://fakelibrary.com")
				.version("1.1.0")
				.build();
	}
}