package com.sv.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;

public class ApplicationInitializer //implements WebApplicationInitializer 
{

	// This is the call back method which is automatically call framework(Server)
	public void onStartup(ServletContext servletContext) throws ServletException {
		// create a WebApplicationContext
//		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
//		applicationContext.setConfigLocation("classpath:Application-Context.xml");
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(AppConfig.class);

		// create dispatcherServlet Object and register that WebApplicationContext with
		// Dispatcher Servlet
		FrameworkServlet  ds = new DispatcherServlet(webApplicationContext);

		// register DispatcherServlet Object with ServletContext;
		ServletRegistration.Dynamic registration = servletContext.addServlet("myDispatcherServlet", ds);
		registration.setLoadOnStartup(1);
		registration.addMapping("/website/*");

	}

}
