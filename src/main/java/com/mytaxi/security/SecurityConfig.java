package com.mytaxi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//@EnableWebSecurity
	public static class SampleMultiHttpSecurityConfig {
		@Autowired
		DataSource datasource;
		
		@Autowired
		 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		   auth.jdbcAuthentication().dataSource(datasource)
		  .usersByUsernameQuery(
		   "SELECT username, password FROM driver WHERE username=?")
		  .authoritiesByUsernameQuery(
		  "SELECT useremail, role FROM tm_admin WHERE useremail=?");
		 } 
	
	@Configuration
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http				
				.authorizeRequests()
						.antMatchers("/v1/drivers/**").hasRole("DRIVER")				
		                .and()
	                .formLogin()
	    	            .loginPage("/login")
	    	            .usernameParameter("username").passwordParameter("password")
	    	            .permitAll()
	    	            .and()
	    	        .logout()
	                	.permitAll()
	                	.and()
	                    .csrf();
	    	}
	}

}}