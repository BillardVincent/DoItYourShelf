package fr.DIYshelf.DoItYourshelf.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Repositories.QuantityOfArticleRepository;

@Service
public class QuantityOfArticleService {
	
	@Autowired
	private QuantityOfArticleRepository qOfArtRepo;
	
	public void createQofArt (QuantityOfArticle qOfArt) {
		qOfArtRepo.save(qOfArt);
	}
	
	public Optional<QuantityOfArticle> findQofArtById(int id) {
		return qOfArtRepo.findById(id);
	}

}
