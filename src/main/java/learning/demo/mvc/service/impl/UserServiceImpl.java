package learning.demo.mvc.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.demo.mvc.model.Response;
import learning.demo.mvc.model.User;
import learning.demo.mvc.service.UserService;
import learning.demo.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository repo;

	@Override
	public Response createUser(User user) {
		logger.info("service layer create user");
		Response response = new Response();
		Integer idCreated = repo.createUser(user);
		response.setId(idCreated);
		response.setMessage("User inserted successfully.");
		return response;
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("service layer getAllUsers");
		List<User> userList = repo.getAllUsers();
		logger.info("retrieved all users");
		return userList;
	}

}
