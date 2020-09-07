package fr.DIYshelf.DoItYourshelf.Test;

import java.util.Optional;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.ElementsMock.ArticleRandGen;
import fr.DIYshelf.DoItYourshelf.Services.ToBuy;
import fr.DIYshelf.DoItYourshelf.Services.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("TEST")

public class ToBuyTest {
	
	@InjectMocks
	private ToBuy toBuy;
	@Mock
	private UserService userService;
		
	@Test

	public void generateList() {
		
		User user = new User();
		ArticleRandGen artRandGen =new ArticleRandGen();
		Set<Article> articleList = artRandGen.ListArticle(5, 8);
		user.setArticles(articleList);
		Optional<User> optUser = Optional.of(user);
		// Mocker l'optionnal, puis le des-optionnaliser ?
		Mockito.when(userService.getUserByName(user.getUsername())).thenReturn(optUser);
		Set<Article> list = toBuy.generateToBuyList(user);
		
			assert(list.size()!=(0));
			assert(list.size()==(5));
			for (Article article : list) {
				assert(article.getInstOfArt().size()==(1));



			}


			
		
	}

}

