package fr.DIYshelf.DoItYourshelf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	
	public User getUserByName(String name) {
		User user = userRepository.getUserByName(name);
		return user;
	}
	

}
