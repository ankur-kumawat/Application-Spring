package learning.demo.mvc.application.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private static final Logger log = LogManager.getLogger(WebInitializer.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.debug("No Root Config Classes");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.debug("Setting servlet config to ConfigurationSupport.class");
		return new Class[] {ConfigurationSupport.class};
	}

	@Override
	protected String[] getServletMappings() {
		log.debug("Setting root servlet mappings");
		return new String[] {"/"};
	}

}
 