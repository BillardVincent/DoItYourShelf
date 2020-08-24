package fr.dawan.QuestionQCM;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;

class ArticlePersistanceTest {

	@Autowired
	ArticleRepository articleRepo;
	
	@Test
	void InsertArticle() {
		Article article = new Article();
		article.setName("name");
		article.setAlias("alias");
		assert(article.getAlias().equals("alias"));

		articleRepo.save(article);
		assert(article.getId()!=0);
		
	}

}
