package com.sv.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class<?>[] classe = { AppContext.class };
		return classe;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] classes = { AppConfig.class };
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMapping = { "/" };
		return urlMapping;
	}

}
