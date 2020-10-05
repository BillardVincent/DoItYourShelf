package fr.DIYshelf.DoItYourshelf.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;
import fr.DIYshelf.DoItYourshelf.Repositories.QuantityOfArticleRepository;

@Service
public class QuantityOfArticleService {
	
	 @Autowired
	 QuantityOfArticleRepository instOfArtRepo;
	 @Autowired
	 ArticleRepository articleRepo;
	 
	 
	 public void CreateOrUpdate(QuantityOfArticle instOfArt) {
		 
	 }
	 
public Set<QuantityOfArticle> getAllFromArticle(Article article) {
	
	return articleRepo.getArticleByName(article.getName()).getInstOfArt();
		 
	 }
}
