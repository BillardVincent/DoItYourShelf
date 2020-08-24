package fr.dawan.QuestionQCM;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

class ArticleTest {

	@Test
	void createArticle() {
		Article article = new Article();
		article.setName("name");
		article.setAlias("alias");
		assert(article.getAlias().equals("alias"));
		
	}

}
