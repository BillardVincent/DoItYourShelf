package fr.DIYshelf.DoItYourshelf.ElementsMock;

import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.User;

@Service
public class UserRandGen {
	
	InstOfArticleRandGen ioarg= new InstOfArticleRandGen();

	public User UserMocked(String var) {
		User user = new User();
		user.setUsername("name" + var);
		user.setEmail("Email" + var);
		user.setPassword("Password" + var);

		return user;
	}
	
	

}
