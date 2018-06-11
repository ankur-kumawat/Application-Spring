package learning.demo.mvc.web.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	private static final Logger logger = LogManager.getLogger(DefaultController.class);
	
	@RequestMapping("/")
	public String home(ModelMap map) {
		logger.info("Redirecting to index.html");
		return "index";
	}
}
