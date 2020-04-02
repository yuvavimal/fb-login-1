package com.infotech.app.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableOAuth2Sso
@Configuration
public class Oauth2fblogin extends WebSecurityConfigurerAdapter {
	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().antMatcher("/**").authorizeRequests().antMatchers("/", "/login**").permitAll()
			.anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();
		 
		
	 }
	 /*@Override
	 public void configure(WebSecurity web) throws Exception {
	     web.ignoring().antMatchers("/login");
	 } */
	 
	 

}
