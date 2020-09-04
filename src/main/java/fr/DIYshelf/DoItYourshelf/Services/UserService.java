package fr.DIYshelf.DoItYourshelf.Services;

import java.util.Optional;

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
	
	public Optional<User> getUserByName(String name) {
		Optional<User> user = userRepository.getUserByName(name);
		return user;
	}
	

}
