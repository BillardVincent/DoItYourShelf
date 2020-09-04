package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Services.ToBuy;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/toBuyList")
public class ToBuyController {


	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping(value = "/generate", consumes = "application/json", produces = "application/json")
	public Set<Article> Generate(@RequestBody User userFromFront) {
		ToBuy toBuyService= new ToBuy();

		Set <Article> toBuyList = toBuyService.generateToBuyList(userFromFront);
		return toBuyList;
	}

	
}
