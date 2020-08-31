package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;



@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public void saveOrUpdate(Article article) {
		articleRepository.save(article);

		Article articleFromDB = articleRepository.getArticleByName(article.getName());
		
		if(articleFromDB == null) {
			articleRepository.save(article);
		}
		else {
			articleFromDB.setName(article.getName());
			articleFromDB.setType(article.getType());
			articleFromDB.setAlias(article.getAlias());
			articleFromDB.setFormat(article.getFormat());
			articleFromDB.setFormat2(article.getFormat2());
			
			//TODO
			
			articleRepository.save(articleFromDB);
		}
		
		
	}

	public List<Article> FindAll(){
	return articleRepository.findAll();
	
	
}
	public Article FindByName(String name) {
		return articleRepository.getArticleByName(name);
	}
}