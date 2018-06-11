package learning.demo.mvc.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learning.demo.mvc.model.Response;
import learning.demo.mvc.model.User;
import learning.demo.mvc.service.UserService;


@RestController
@RequestMapping(value="/api")
public class RequestController {

	private static final Logger logger = LogManager.getLogger(RequestController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/allUsers", method = RequestMethod.GET, produces= {"application/json"})
	public List<User> allUsers() {
		logger.info("allUsers");
		List<User> allUsers = userService.getAllUsers();
		logger.info("Sending allUsers response");
		return allUsers;
	}
	
	@RequestMapping(value="/loginRequest", method = RequestMethod.GET, produces= {"application/json"})
	public Object loginRequest() {
		logger.info("loginRequest");
		Response response = new Response();
		logger.info("Sending simple response");
		return response;
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST, consumes = {"application/json"},produces= {"application/json"})
	public Object createUser(@RequestBody User user) {
		logger.info("createUser");
		Response response = userService.createUser(user);
		logger.info("created user");
		return response;
	}
}
