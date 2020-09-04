package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Services.ArticleService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping(value = "/createOrUpdate", consumes = "application/json", produces = "application/json")
	public String Create(@RequestBody Article articleFromFront) {
		articleService.saveOrUpdate(articleFromFront);
		String message = "JobDone";
		return message;
	}

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping(value = "")
	public List<Article> ListAllArticle() {
		List<Article> list = articleService.FindAll();
		return list;

	}
}
