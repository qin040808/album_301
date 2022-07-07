package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().mvcMatchers("/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().mvcMatchers("/", "/sign-up", "/fileUpload", "/upload", "/results").permitAll()
				.anyRequest().authenticated().and().formLogin().usernameParameter("id").defaultSuccessUrl("/album")
				.loginPage("/login").permitAll().and().logout().permitAll();
		http.cors().and();
		http.csrf().disable();

//		http.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);

		http.logout().logoutSuccessUrl("/");
	}

}
