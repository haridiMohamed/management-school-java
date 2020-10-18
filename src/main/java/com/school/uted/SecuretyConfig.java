package com.school.uted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)//
public class SecuretyConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof").password("prof").roles("PROF");
		auth.inMemoryAuthentication().withUser("scrt").password("scrt").roles("SCOLARITE");
		auth.inMemoryAuthentication().withUser("std").password("std").roles("ETUDIANT");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
			.authorizeRequests()
			.antMatchers("/css/**","/js/**","/image/**").permitAll()
				.anyRequest()
					.authenticated()
						.and()
							.formLogin()
								.loginPage("/login")
								    .permitAll()
								    .defaultSuccessUrl("/admin/addproducts")
								    ;
		
	}

}
