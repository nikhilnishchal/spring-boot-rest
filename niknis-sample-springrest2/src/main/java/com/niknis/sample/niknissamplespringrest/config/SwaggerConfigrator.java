package com.niknis.sample.niknissamplespringrest.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Class to hold configuration and enable swagger
@Configuration
@EnableSwagger2
public class SwaggerConfigrator {
	
	private static final Contact DEFAULT_CONTACT = new Contact("Nikhil Nishchal", "http://www.nikhilnishchal.com", "nikhil.nishchal001@gmail.com");
	
	private static final ApiInfo DOCUMENT_APP_INFO = new ApiInfo("NikNis Api Documentation", "Description for the document", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUME = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	

	@Bean
	public Docket api() {
		//return new Docket(DocumentationType.SWAGGER_2);
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DOCUMENT_APP_INFO)
				.produces(DEFAULT_PRODUCE_AND_CONSUME);
	}
}
