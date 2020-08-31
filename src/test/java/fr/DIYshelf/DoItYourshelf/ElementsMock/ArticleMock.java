package fr.DIYshelf.DoItYourshelf.ElementsMock;

import java.util.HashSet;
import java.util.Set;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

public class ArticleMock {

	public Article ArticleMocked(String var) {
		Article article = new Article();
			article.setAlias("alias"+var);
			article.setName("name"+var);
	
		
return article;
}
	
	public Set<Article> ListArticle(int nArticles){
		Set<Article> articles = new HashSet<Article>();
		for (int i = 0; i <nArticles; i++) {
			Article article = ArticleMocked(String.valueOf(i));
			articles.add(article);
		}
		return articles;
	}
	
}
