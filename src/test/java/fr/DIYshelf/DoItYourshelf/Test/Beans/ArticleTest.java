package fr.DIYshelf.DoItYourshelf.Test.Beans;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.Photo;
import fr.DIYshelf.DoItYourshelf.Beans.Rangement;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Enum.Formats;
import fr.DIYshelf.DoItYourshelf.Enum.Units;

@ActiveProfiles("TEST")

class ArticleTest {

	@Test
	void createArticle() {
		Article article = new Article();
		article.setName("name");
		article.setAlias("alias");
		article.setFormat(Formats.UNIT);
		article.setFormat2(Formats.BOX);
		Set<QuantityOfArticle> instOfArt = new HashSet<QuantityOfArticle>();
		article.setInstOfArt(instOfArt);
		Set<Photo> photos = new HashSet<Photo>();
		article.setPhotos(photos);
		article.setPrice(100d);
		Rangement rangement =new Rangement();
		article.setRangement(rangement);
		article.setPlaceOfBuying("placeOfBuying");
		article.setType("type");
		article.setUnit1(Units.KG);
		article.setUnit2(Units.KG);
		article.setUnit3(Units.KG);
		article.setUnit4(Units.KG);
		User user = new User();
		article.setUser(user);

		
		assert(article.getAlias().equals("alias"));
		assert(article.getName().equals("name"));
		assert(article.getFormat().equals(Formats.UNIT));
		assert(article.getFormat2().equals(Formats.BOX));
		assert(article.getInstOfArt().equals(instOfArt));
		assert(article.getPhotos().equals(photos));
		assert(article.getPrice().equals(100d));
		assert(article.getRangement().equals(rangement));
		assert(article.getPlaceOfBuying().equals("placeOfBuying"));
		assert(article.getType().equals("type"));
		assert(article.getUnit1().equals(Units.KG));
		assert(article.getUnit2().equals(Units.KG));
		assert(article.getUnit3().equals(Units.KG));
		assert(article.getUnit4().equals(Units.KG));
		assert(article.getUser().equals(user));

		
	}

}
