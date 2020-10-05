package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.Format;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.DTO.request.ArticlePatternRequest;
import fr.DIYshelf.DoItYourshelf.DTO.response.ArticlePatternResponse;
import fr.DIYshelf.DoItYourshelf.Exceptions.ElementNotFoundException;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticlePatternRepository;



@Service
public class ArticlePatternService {
	
	@Autowired
	private ArticlePatternRepository articlePatternRepository;
	@Autowired
	private FormatsAndUnitsService fnUService;
	
	public void saveOrUpdate(ArticlePattern articlePattern) {
		articlePatternRepository.save(articlePattern);

		ArticlePattern articlePatternFromDB = findById(articlePattern.getId()).orElse(null);
		
		if(articlePatternFromDB == null) {
			articlePatternRepository.save(articlePattern);
		}
		else {
			articlePatternFromDB.setName(articlePattern.getName());
			articlePatternFromDB.setFormat(articlePattern.getFormat());
			
			//TODO
			
			articlePatternRepository.save(articlePatternFromDB);
		}
	
	
}
	/*
	public ArticlePattern FindByName(String name, int userId) {
		return articlePatternRepository.getArticlePatternByNameandUser(name, userId);
	}
	*/

	public List<ArticlePattern> FindAllByUser(int userId) {
				return articlePatternRepository.findAllByUser(userId) ;
	}

	public Optional<ArticlePattern> findById(int id) {
		return articlePatternRepository.findById(id);
	}
	
	public ArticlePatternResponse artPatToArtPatResp(ArticlePattern artPat) {
		ArticlePatternResponse artPatResp = new ArticlePatternResponse();
		artPatResp.name=artPat.getName();
		artPatResp.id=artPat.getId();
		if(artPat.getFormat()!=null) {
			artPatResp.formatId=(artPat.getFormat().getId());
		}
		return artPatResp;
	}
	public ArticlePattern artReqToArticlePattern(ArticlePatternRequest artPatReq) {
		ArticlePattern artPat = new ArticlePattern();
		artPat.setName(artPatReq.name);
		artPat.setId(artPatReq.id);
		Format format = fnUService.getFormat(artPatReq.formatId).orElseThrow(() ->new ElementNotFoundException("Format Not Found "));
		artPat.setFormat(format);
		
		return artPat;
	}
}