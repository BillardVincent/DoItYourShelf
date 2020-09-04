package fr.DIYshelf.DoItYourshelf.Test;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.ElementsMock.ArticleRandGen;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("TEST")
class ArticlePersistanceTest {

	
	@Autowired
	ArticleRepository articleRepo;
	
	ArticleRandGen artMock = new ArticleRandGen();
	
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
