package fr.DIYshelf.DoItYourshelf.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.InstanceOfArticle;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;
import fr.DIYshelf.DoItYourshelf.Repositories.InstanceOfArticleRepository;

@Service
public class InstanceOfArticleService {
	
	 @Autowired
	 InstanceOfArticleRepository instOfArtRepo;
	 @Autowired
	 ArticleRepository articleRepo;
	 
	 
	 public void CreateOrUpdate(InstanceOfArticle instOfArt) {
		 
	 }
	 
public Set<InstanceOfArticle> getAllFromArticle(Article article) {
	Set<InstanceOfArticle> list = (articleRepo.getArticleByName(article.getName()).getInstOfArt());
	
	return list;
		 
	 }
}
