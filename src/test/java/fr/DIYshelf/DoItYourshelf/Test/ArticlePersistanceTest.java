package fr.DIYshelf.DoItYourshelf.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.ElementsMock.ArticleRandGen;
import fr.DIYshelf.DoItYourshelf.ElementsMock.UserRandGen;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;
import fr.DIYshelf.DoItYourshelf.Repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("TEST")
class ArticlePersistanceTest {

	
	@Autowired
	ArticleRepository articleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ArticleRandGen artMock;
	@Autowired
	UserRandGen userMock;
	
	@Test
	void InsertArticle() {
		Article article = new Article();
		article.setName("name");
		article.setAlias("alias");
		assert(article.getAlias().equals("alias"));

		articleRepo.save(article);
		
		assert(article.getId()!=0);
		
		articleRepo.delete(article);
		
	}
	
	@Test
	void FindArtByUserId() {
		Article articleA = artMock.ArticleMocked("a");
		Article articleB = artMock.ArticleMocked("b");
		User userA = userMock.UserMocked("a");
		userRepo.save(userA);
		articleA.setUser(userA);
		articleRepo.save(articleA);
		articleB.setUser(userA);
		articleRepo.save(articleB);

		Article articleC = artMock.ArticleMocked("c");
		Article articleD = artMock.ArticleMocked("d");
		User userB = userMock.UserMocked("b");
		userRepo.save(userB);
		articleC.setUser(userB);
		articleRepo.save(articleC);
		articleD.setUser(userB);
		articleRepo.save(articleD);
		
		List<Article> listA = articleRepo.findAllByUser(userA.getId());
		assertEquals(2, listA.size());
		List<Article> listB = articleRepo.findAllByUser(userB.getId());
		assertEquals(2, listB.size());
		
		articleRepo.delete(articleA);
		articleRepo.delete(articleB);
		articleRepo.delete(articleC);
		articleRepo.delete(articleD);
		
		userRepo.delete(userA);
		userRepo.delete(userB);




	}
	
	
	

}
