package com.niknis.sample.niknissamplespringrest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class NiknisSampleSpringrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiknisSampleSpringrestApplication.class, args);
	}

	/* For locale or internationalization loaded bean for it */
	@Bean
	public LocaleResolver localeResolver() {
		/*
		 in this we need to pass locale as parameter DemoMessageResource.getInternationalizedMsg
		 
		// SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		 as we are using locale as "Accept-language" so we can use AcceptHeaderLocaleResolver and we can get the locale from context also without giving locale parameter as requestparameter or header as
		 DemoMessageResource.getInternationalizedMsgCTX
		 */
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	/* Load message source for different language */
	/*
	 * Note: the method name should be "messageSource()" as same name of bean defined (I autowired in DemoMessageResourse): so be careful for this method name. We can use these method feature by below property from
	 * aplication.properties "
	 * 
	 * spring.messages.basename=message/messages 
	 * spring.messages.encoding=UTF-8
	 * 
	 */

	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}*/

}
