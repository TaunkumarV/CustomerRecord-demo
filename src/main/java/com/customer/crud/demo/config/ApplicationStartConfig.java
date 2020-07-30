package com.customer.crud.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * @author Tarun
 *
 */

public class ApplicationStartConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext appcontainer) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(appcontainer);
		ServletRegistration.Dynamic servlet = appcontainer.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
