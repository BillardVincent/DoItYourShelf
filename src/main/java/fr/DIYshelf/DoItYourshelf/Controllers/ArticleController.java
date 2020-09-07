package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Security.AuthTokenFilter;
import fr.DIYshelf.DoItYourshelf.Security.JwtUtils;
import fr.DIYshelf.DoItYourshelf.Services.ArticleService;
import fr.DIYshelf.DoItYourshelf.Services.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthTokenFilter  authTokenFilter;

	@Autowired
	private UserService  userService;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping(value = "/createOrUpdate", consumes = "application/json", produces = "application/json")
	public String Create(HttpServletRequest request, @RequestBody Article articleFromFront, @RequestBody User userFromFront) {
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		String message;
		if(userFromFront.getUsername().equals(usernameFromToken)) {
			User user = userService.getUserByName(usernameFromToken).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
			articleFromFront.setUser(user);
			articleService.saveOrUpdate(articleFromFront);
			message = "JobDone";
		}else {
			message ="Error";
		}
		
		
		return message;
	}

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping(value = "")
	public List<Article> ListAllArticle(HttpServletRequest request) {
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		User user = userService.getUserByName(usernameFromToken)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		int userId = user.getId();
		List<Article> list = articleService.FindAllByUser(userId);
		return list;

	}
}
