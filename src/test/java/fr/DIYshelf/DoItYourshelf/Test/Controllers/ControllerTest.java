package fr.DIYshelf.DoItYourshelf.Test.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import fr.DIYshelf.DoItYourshelf.Repositories.UserRepository;

@ActiveProfiles("TEST")

@AutoConfigureMockMvc

class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	UserRepository userRepository;
	
	@Test
	void SignIn()throws Exception {
		
	
	}
}

