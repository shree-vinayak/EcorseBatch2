package com.sv.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class<?>[] classe = {  };
		return classe;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] classes = { AppContext.class, AppConfig.class };
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMapping = { "/" };
		return urlMapping;
	}

}
