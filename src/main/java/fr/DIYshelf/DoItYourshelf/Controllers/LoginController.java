package fr.DIYshelf.DoItYourshelf.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Services.UserService;
import fr.DIYshelf.DoItYourshelf.ressources.ConstantStrings;

@RestController
@CrossOrigin (origins= {"http://localhost:4200", "http://localhost:8080"})
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/log")
	public String Login(User userFromFront) {
		String message ="";
		User userDB = userService.getUserByName(userFromFront.getName());
		if (userDB.getPassword().equals(userFromFront.getPassword())){
			message = ConstantStrings.SUCCES;
		}else {
			message =ConstantStrings.FAIL;
		}
		return message;
	}
	
	// TO DO
	@PostMapping(value="/createUser", consumes = "application/json", produces = "application/json")
	public String CreateUser(@RequestBody User userFromFront ) {
		String message ="";
		System.out.println(userFromFront.getName());
		System.out.println(userFromFront.getPassword());
		User userDB = userService.getUserByName(userFromFront.getName());
		if (userDB==null) {
			userService.createUser(userFromFront);
			message=ConstantStrings.USERCREATED;
		}else {
			message =ConstantStrings.FAIL;
		}
		return message;
	}

}
