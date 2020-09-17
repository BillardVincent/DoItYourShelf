package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.DTO.response.ArticleResponse;
import fr.DIYshelf.DoItYourshelf.Exceptions.ElementNotFoundException;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;



@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticlePatternService artPatService;
	
	public void saveOrUpdate(Article article) {
		articleRepository.save(article);

		Article articleFromDB = articleRepository.findById(article.getId()).orElse(null);
		
		if(articleFromDB == null) {
			articleRepository.save(article);
		}
		else {
			articleFromDB.setName(article.getName());
			articleFromDB.setType(article.getType());
			articleFromDB.setAlias(article.getAlias());
			//articleFromDB.setFormat(article.getFormat());

			
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

	public List<Article> FindAllByUser(int userId) {
				return articleRepository.findAllByUser(userId) ;
	}

	public Optional<Article> findById(int id) {
		return articleRepository.findById(id);
	}
	
	public ArticleResponse articleToArtResp(Article article) {
		ArticleResponse artResp = new ArticleResponse();
		artResp.name=article.getName();
		artResp.id=article.getId();
		artResp.alias=article.getAlias();
		if (article.getArticlePattern() != null) {
		artResp.artPatId=article.getArticlePattern().getId();
		artResp.artPatName=article.getArticlePattern().getName();
		}
		return artResp;
	}
	public Article artRespToArticle(ArticleResponse artResp) {
		Article article = new Article();
		article.setName(artResp.name);
		article.setId(artResp.id);
		article.setAlias(artResp.alias);
		if (artResp.artPatId != 0) {
			ArticlePattern artPatFromDB = artPatService.findById(artResp.artPatId).orElseThrow(() -> new ElementNotFoundException("Pattern Not Found "));
		article.setArticlePattern(artPatFromDB);
		}
		return article;
	}
	
	
	
	
}