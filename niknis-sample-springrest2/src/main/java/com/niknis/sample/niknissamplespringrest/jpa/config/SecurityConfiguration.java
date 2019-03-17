package com.niknis.sample.niknissamplespringrest.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("==================" + web.toString());
		web.ignoring()
				// Spring Security should completely ignore URLs starting with /resources/
				.antMatchers("/h2-console/**");
		// .antMatchers(HttpMethod.POST, "/**");
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 BCryptPasswordEncoder encoder = passwordEncoder();
		auth.inMemoryAuthentication()
				.passwordEncoder(encoder)
				.withUser("nikhil").password(encoder.encode("password")).roles("USER");// .and().withUser("admin1").password("secret1").roles("USER",
																		// "ADMIN");
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/**").hasRole("USER").and()// .antMatchers("/**").hasRole("ADMIN").and()
				.csrf().disable().headers().frameOptions().disable();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
	 * .hasRole("USER");//.and() System.out.println("---------------"); // Possibly
	 * more configuration ... //.formLogin() // enable form based log in // set
	 * permitAll for all URLs associated with Form Login // .permitAll(); }
	 */
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth // enable in memory based authentication with a user named
	 * "user" and "admin"
	 * .inMemoryAuthentication().withUser("user").password("password").roles("USER")
	 * .and().withUser("admin").password("password").roles("USER", "ADMIN"); }
	 */

}