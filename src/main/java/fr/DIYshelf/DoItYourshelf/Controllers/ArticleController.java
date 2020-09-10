package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.List;

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
import fr.DIYshelf.DoItYourshelf.DTO.response.MessageResponse;
import fr.DIYshelf.DoItYourshelf.Ressources.ConstantStrings;
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
	public MessageResponse Create(HttpServletRequest request, @RequestBody Article articleFromFront) {
		System.out.println("inside article/createOrUpdate");
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		System.out.println(articleFromFront.getName());
			User user = userService.getUserByName(usernameFromToken).orElseThrow(() -> new UsernameNotFoundException(ConstantStrings.USER_NOT_FOUND + usernameFromToken));
			articleFromFront.setUser(user);
			articleService.saveOrUpdate(articleFromFront);
		MessageResponse messageResp =new MessageResponse(ConstantStrings.SUCCES);
		
		return messageResp;
	}

	@GetMapping(value = "")
	public List<Article> ListAllArticle(HttpServletRequest request) {
		System.out.println("inside article/");
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		System.out.println("inside article/ -- user from token =" + usernameFromToken);

		User user = userService.getUserByName(usernameFromToken)
				.orElseThrow(() -> new UsernameNotFoundException(ConstantStrings.USER_NOT_FOUND + usernameFromToken));
		int userId = user.getId();
		List<Article> list = articleService.FindAllByUser(userId);
		return list;

	}
}
