package com.sv.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//This class is going to help you to create  the spring security filter chain	
@EnableWebSecurity(debug=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

}
