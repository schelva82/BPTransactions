package com.bp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// TODO: Auto-generated Javadoc
/**
 * The Class WebInit.
 */
public class WebInit implements WebApplicationInitializer {

	/**
	 * On startup.
	 *
	 * @param container the container
	 */
	@Override
	public void onStartup(ServletContext container) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);

		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = container.addServlet("dispatcher", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/backbase/*");
	}
}
