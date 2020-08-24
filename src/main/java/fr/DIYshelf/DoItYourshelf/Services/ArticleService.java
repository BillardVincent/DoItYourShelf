package fr.DIYshelf.DoItYourshelf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;

import java.util.List;
import java.util.Optional;



@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public void saveOrUpdate(Article article) {
		articleRepository.save(article);
	}

	public List<Article> FindAll(){
	List <Article> listFromRepo = articleRepository.findAll();
	return listFromRepo;
	
	
}
}