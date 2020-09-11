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
import fr.DIYshelf.DoItYourshelf.DTO.request.ArticleRequest;
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

	@PostMapping(value = "/createOrUpdate")
	public void Create(HttpServletRequest request, @RequestBody ArticleRequest articleFromAng) {
		System.out.println("creation");
		Article articleFromFront = new Article();
		if (articleFromAng.id!=0) articleFromFront.setId(articleFromAng.id);
		if (!articleFromAng.name.equals(""))articleFromFront.setName(articleFromAng.name);
		if (!articleFromAng.alias.equals(""))articleFromFront.setAlias(articleFromAng.alias);
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		String message;
		System.out.println("creation2");

		User user = userService.getUserByName(usernameFromToken).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		articleFromFront.setUser(user);
		System.out.println(articleFromFront);
		articleService.saveOrUpdate(articleFromFront);
		message = "JobDone";
		System.out.println(message);

	}

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
