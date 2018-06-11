package learning.demo.repositories;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import learning.demo.mvc.model.User;


@Repository
@Transactional
public class UserRepository {

	/*@Autowired
	HibernateTemplate template;*/
	
	
	@Autowired
	Session session;
	
	public List<User> getAllUsers(){
		return this.session.createCriteria(User.class).list();
	}
	
	@Transactional
	public Integer createUser(User user) {
		
		//Transaction tx = session.beginTransaction();
		Serializable userId = this.session.save(user);
		//tx.commit();
		return (Integer) userId;
	}
}
