package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.DTO.request.ArticlePatternRequest;
import fr.DIYshelf.DoItYourshelf.Exceptions.ElementNotFoundException;
import fr.DIYshelf.DoItYourshelf.Security.AuthTokenFilter;
import fr.DIYshelf.DoItYourshelf.Security.JwtUtils;
import fr.DIYshelf.DoItYourshelf.Services.ArticlePatternService;
import fr.DIYshelf.DoItYourshelf.Services.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/pattern")
public class ArticlePatternController {

	@Autowired
	ArticlePatternService articlePatternService;
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthTokenFilter authTokenFilter;

	@Autowired
	private UserService  userService;

	@PostMapping(value = "/createOrUpdate")
	public void Create(HttpServletRequest request, @RequestBody ArticlePatternRequest articlePatternFromAng) {
		System.out.println(articlePatternFromAng.name);
		System.out.println(articlePatternFromAng.id);
		System.out.println(articlePatternFromAng.formatId);

		ArticlePattern articlePatternFromFront = articlePatternService.artReqToArticlePattern(articlePatternFromAng);
		/*if (articlePatternFromAng.id!=0) articlePatternFromFront.setId(articlePatternFromAng.id);
		if (!articlePatternFromAng.name.equals(""))articlePatternFromFront.setName(articlePatternFromAng.name);
		*/
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		//String message;
		User user = userService.getUserByName(usernameFromToken).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		articlePatternFromFront.setUser(user);
		articlePatternService.saveOrUpdate(articlePatternFromFront);
		//message = "JobDone";
		//System.out.println(message);

	}

	@GetMapping(value = "")
	public List<ArticlePattern> ListAllArticlePattern(HttpServletRequest request) {
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		User user = userService.getUserByName(usernameFromToken)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		int userId = user.getId();
		List<ArticlePattern> list = articlePatternService.FindAllByUser(userId);
		return list;
	}
	
	@GetMapping(value="/details/{id}")
	public ArticlePattern GetArticlePatternDetailed(HttpServletRequest request, @PathVariable("id") int id) {
		ArticlePattern articlePattern = articlePatternService.findById(id).orElseThrow(() -> new ElementNotFoundException("User Not Found with username: "));
		return articlePattern;
		
	}
}
