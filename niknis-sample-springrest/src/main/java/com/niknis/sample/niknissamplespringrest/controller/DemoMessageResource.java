package com.niknis.sample.niknissamplespringrest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMessageResource {
	
	@Autowired
	private MessageSource messageSource;

	//Return internationalized message based on locale found in request header "Accept-Language", else default locale is used as per configuration (required false)
	@GetMapping(path="/message")
	public String getInternationalizedMsg(@RequestHeader(name="Accept-Language", required=false) String language) {
		return messageSource.getMessage("niknis.greet.message", null, new Locale(language));
	}
	
	/* get locale from context loader without passing as parameter */
	@GetMapping(path="/message-context")
	public String getInternationalizedMsgCTX() {
		return messageSource.getMessage("niknis.greet.message", null, LocaleContextHolder.getLocale());
	}
}
