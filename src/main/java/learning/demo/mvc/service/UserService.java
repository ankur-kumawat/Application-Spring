package learning.demo.mvc.service;

import java.util.List;

import learning.demo.mvc.model.Response;
import learning.demo.mvc.model.User;


public interface UserService {

	Response createUser(User user);

	List<User> getAllUsers();

}
