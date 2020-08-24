package fr.dawan.QuestionQCM;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;

class UserTest {

	@Test
	void createUser() {
		User user = new User();
		user.setName("name");
		user.setPassword("password");
		assert(user.getName().equals("name"));
		
	}

}
