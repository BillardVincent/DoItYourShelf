package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.DTO.request.ArticleRequest;
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
	public Article artRespToArticle(ArticleRequest artReq) {
		Article article = new Article();
		article.setName(artReq.name);
		article.setId(artReq.id);
		article.setAlias(artReq.alias);
		if (artReq.artPatId != 0) {
			ArticlePattern artPatFromDB = artPatService.findById(artReq.artPatId).orElseThrow(() -> new ElementNotFoundException("Pattern Not Found "));
		article.setArticlePattern(artPatFromDB);
		}
		return article;
	}

	public void deleteArticle(Article article) {
		articleRepository.delete(article);
	}

	public void deleteArticlebyId(int id) {
articleRepository.deleteById(id);		
	}

	public ArticleResponse QOfArticleToArtResp(QuantityOfArticle qOfArticle) {
		ArticleResponse articleResp = new ArticleResponse();
		articleResp.name = qOfArticle.getMotherArticle().getName();
		articleResp.alias = qOfArticle.getMotherArticle().getAlias();
		if (qOfArticle.getMotherArticle().getArticlePattern() != null) {
			articleResp.artPatId =  qOfArticle.getMotherArticle().getArticlePattern().getId();
		articleResp.artPatName =  qOfArticle.getMotherArticle().getArticlePattern().getName();
		}
		return articleResp;
	}
	
	
	
	
	
}