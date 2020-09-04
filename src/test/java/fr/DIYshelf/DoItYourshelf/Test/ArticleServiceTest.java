package fr.DIYshelf.DoItYourshelf.Test;


import static org.junit.Assert.assertEquals;

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
import fr.DIYshelf.DoItYourshelf.ElementsMock.ArticleRandGen;
import fr.DIYshelf.DoItYourshelf.Repositories.ArticleRepository;
import fr.DIYshelf.DoItYourshelf.Services.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("TEST")

public class ArticleServiceTest {
	
	@InjectMocks
	private ArticleService articleService;
	@Mock
	private ArticleRepository articleRepository;
	
	@Test
	public void ArticleServiceAvecInjectMock() {
		ArticleRandGen articleMock = new ArticleRandGen();
		Article article = articleMock.ArticleMocked("test1");
		String name =article.getName();
		
		Mockito.when(articleRepository.getArticleByName(name)).thenReturn(article);
		assertEquals(name, articleService.FindByName(name).getName());
	}
		
}
