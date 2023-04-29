package com.sv.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] classes= {AppConfig.class}; 
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
	String[] urlMapping= {"/"};
		return urlMapping;
	}

}
