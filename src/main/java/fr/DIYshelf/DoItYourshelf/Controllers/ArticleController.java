package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.Project;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.DTO.request.ArticleRequest;
import fr.DIYshelf.DoItYourshelf.DTO.request.QuantityOfArticleRequest;
import fr.DIYshelf.DoItYourshelf.DTO.response.ArticleResponse;
import fr.DIYshelf.DoItYourshelf.Exceptions.ElementNotFoundException;
import fr.DIYshelf.DoItYourshelf.Security.AuthTokenFilter;
import fr.DIYshelf.DoItYourshelf.Security.JwtUtils;
import fr.DIYshelf.DoItYourshelf.Services.ArticlePatternService;
import fr.DIYshelf.DoItYourshelf.Services.ArticleService;
import fr.DIYshelf.DoItYourshelf.Services.ProjectService;
import fr.DIYshelf.DoItYourshelf.Services.QuantityOfArticleService;
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
	@Autowired
	private ArticlePatternService  artPatService;
	@Autowired
	private QuantityOfArticleService qOfArtService;
	@Autowired
	ProjectService projectService;


	@PostMapping(value = "/createOrUpdate")
	public void Create(HttpServletRequest request, @RequestBody ArticleRequest articleFromAng) {
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		String message;

		User user = userService.getUserByName(usernameFromToken).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		Article articleFromFront = new Article();
		if (articleFromAng.id!=0) articleFromFront.setId(articleFromAng.id);
		if (!articleFromAng.name.equals(""))articleFromFront.setName(articleFromAng.name);
		if (!articleFromAng.alias.equals(""))articleFromFront.setAlias(articleFromAng.alias);
		
		if (articleFromAng.artPatId!=0) {
			ArticlePattern artPat = artPatService.findById(articleFromAng.artPatId).orElseThrow(() ->new ElementNotFoundException("Pattern Not Found "));
			articleFromFront.setArticlePattern(artPat);
		}
		QuantityOfArticle qOfArt = qOfArtService.findQofArtById(articleFromAng.qOfArtId).orElse(new QuantityOfArticle());
		qOfArt.setUnit1(articleFromAng.quantity1);
		qOfArt.setUnit2(articleFromAng.quantity2);
		qOfArt.setUnit3(articleFromAng.quantity3);
		
		Project storageProject =  projectService.getProjectById(articleFromAng.projectId).orElse(projectService.getProjectStock(user.getId()));
		qOfArt.setProject(storageProject);

		Set<QuantityOfArticle> firstList = new HashSet<QuantityOfArticle>();
		firstList.add(qOfArt);
		articleFromFront.setInstOfArt(firstList);
		

		
		articleFromFront.setUser(user);

		articleService.saveOrUpdate(articleFromFront);
		message = "JobDone";
		System.out.println(message);

	}

	@GetMapping(value = "")
	public List<ArticleResponse> ListAllArticle(HttpServletRequest request) {
		String jwt = authTokenFilter.parseJwt(request);
		String usernameFromToken= jwtUtils.getUserNameFromJwtToken(jwt);
		User user = userService.getUserByName(usernameFromToken)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + usernameFromToken));
		int userId = user.getId();
	
		// List<Article> listArt = articleService.FindAllByUser(userId);
		List<QuantityOfArticle> listArt = projectService.getArticlesFromProjectStock(userId);
		
		List<ArticleResponse> list = new ArrayList<ArticleResponse>();
		for (QuantityOfArticle qOfArticle : listArt) {
			
			list.add(articleService.QOfArticleToArtResp(qOfArticle));
		}
		return list;
		
		
	}
	
	@GetMapping(value="/details/{id}")
	public ArticleResponse GetArticleDetailed(HttpServletRequest request, @PathVariable("id") int id) {
		Article article = articleService.findById(id).orElseThrow(() -> new ElementNotFoundException("Article Not Found "));
		ArticleResponse artResp = articleService.articleToArtResp(article);
		return artResp;
	}
	
	@GetMapping(value="/delete/{id}")
	public void DeleteArticle(@PathVariable("id") int id) {
		System.out.println("delete");
		articleService.deleteArticlebyId(id);
	}
}
