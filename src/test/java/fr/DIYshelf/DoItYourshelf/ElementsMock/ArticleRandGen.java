package fr.DIYshelf.DoItYourshelf.ElementsMock;

import java.util.HashSet;
import java.util.Set;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

public class ArticleRandGen {
	
	InstOfArticleRandGen ioarg= new InstOfArticleRandGen();

	public Article ArticleMocked(String var) {
		Article article = new Article();
		article.setAlias("alias" + var);
		article.setName("name" + var);

		return article;
	}
	
	public Article ArticleMocked(String var, int nInstOfArt) {
		Article article = new Article();
		article.setAlias("alias" + var);
		article.setName("name" + var);
		article.setInstOfArt(ioarg.ListInstOfArtMocked(nInstOfArt));

		return article;
	}

	public Set<Article> ListArticle(int nArticles) {
		Set<Article> articles = new HashSet<Article>();
		for (int i = 0; i < nArticles; i++) {
			Article article = ArticleMocked(String.valueOf(i));
			articles.add(article);
		}
		return articles;
	}
	
	public Set<Article> ListArticle(int nArticles, int nInstOfArtByArt) {
		Set<Article> articles = new HashSet<Article>();
		for (int i = 0; i < nArticles; i++) {
			Article article = ArticleMocked(String.valueOf(i), nInstOfArtByArt);
			articles.add(article);
		}
		return articles;
	}

}
