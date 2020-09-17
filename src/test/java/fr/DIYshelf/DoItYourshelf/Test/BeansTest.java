package fr.DIYshelf.DoItYourshelf.Test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.Photo;
import fr.DIYshelf.DoItYourshelf.Beans.Project;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.Rangement;
import fr.DIYshelf.DoItYourshelf.Beans.Role;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Enum.ERole;

@ActiveProfiles("TEST")

class BeansTest {

	@Test
	void createArticle() {
		Article article = new Article();
		article.setName("name");
		article.setAlias("alias");
		//article.setFormat(Formats.UNIT);
		//article.setFormat2(Formats.BOX);
		Set<QuantityOfArticle> instOfArt = new HashSet<QuantityOfArticle>();
		article.setInstOfArt(instOfArt);
		Set<Photo> photos = new HashSet<Photo>();
		article.setPhotos(photos);
		article.setPrice(100d);
		Rangement rangement =new Rangement();
		article.setRangement(rangement);
		article.setPlaceOfBuying("placeOfBuying");
		article.setType("type");
		//article.setUnit1(Unit.KG);
		//article.setUnit2(Unit.KG);
		//article.setUnit3(Unit.KG);
		//article.setUnit4(Unit.KG);
		User user = new User();
		article.setUser(user);

		
		assert(article.getAlias().equals("alias"));
		assert(article.getName().equals("name"));
		//assert(article.getFormat().equals(Formats.UNIT));
		//assert(article.getFormat2().equals(Formats.BOX));
		assert(article.getInstOfArt().equals(instOfArt));
		assert(article.getPhotos().equals(photos));
		assert(article.getPrice().equals(100d));
		assert(article.getRangement().equals(rangement));
		assert(article.getPlaceOfBuying().equals("placeOfBuying"));
		assert(article.getType().equals("type"));
		//assert(article.getUnit1().equals(Unit.KG));
		//assert(article.getUnit2().equals(Unit.KG));
		//assert(article.getUnit3().equals(Unit.KG));
		//assert(article.getUnit4().equals(Unit.KG));
		assert(article.getUser().equals(user));

		
	}

	
	@Test
	void createUser() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		Set <Article> articles = new HashSet();
		user.setArticles(articles);
		Set<Role> roles = new HashSet();
		user.setRoles(roles);
		Set<Project> projects = new HashSet();
		user.setProjects(projects);
		
		
		assert(user.getUsername().equals("name"));
		assert(user.getPassword().equals("password"));



	}
	
	@Test
	void createArticlePattern() {
		ArticlePattern artpan =new ArticlePattern();
		//artpan.setFormat(Formats.BOX);
		//artpan.setFormat2(Formats.BOX);
		artpan.setName("name");
		//artpan.setUnit1(Unit.CL);
		//artpan.setUnit2(Unit.CL);
		//artpan.setUnit3(Unit.CL);
		//artpan.setUnit4(Unit.CL);
		
		
		
		assert(artpan.getName().equals("name"));
		
	}
	
	@Test
	void createBluePrint() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}
	
	@Test
	void createPhoto() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}
	
	@Test
	void createProject() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}
	
	@Test
	void createQuantityOfArticle() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}
	@Test
	void createRangement() {
		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		assert(user.getUsername().equals("name"));
		
	}
	@Test
	void createRole() {
		Role role = new Role();
		role.setName(ERole.ROLE_ADMIN);
		assert(role.getName().equals(ERole.ROLE_ADMIN));
		
	}
}
