package fr.DIYshelf.DoItYourshelf.Test.Beans;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;

@ActiveProfiles("TEST")

class UserTest {

	@Test
	void createUser() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}

}
