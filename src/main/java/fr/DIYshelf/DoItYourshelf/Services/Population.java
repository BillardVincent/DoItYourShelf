package fr.DIYshelf.DoItYourshelf.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.Project;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.User;

@Service
public class Population {
	
	@Autowired
	FormatsAndUnitsService fnUServ;
	@Autowired
	ArticlePatternService artPatServ;
	@Autowired
	ArticleService articleService;
	@Autowired
	QuantityOfArticleService qOfArtService;
	
	
	public List<QuantityOfArticle> exemplesQuantity(User user, Project project){

		List<QuantityOfArticle> listQofArt = new ArrayList<QuantityOfArticle>();
		
		QuantityOfArticle qOfArt = new QuantityOfArticle();
		Article article = new Article();
		article.setName("Bouton rouge");
		article.setAlias("rouge carmin, 15mm");
		article.setUser(user);
		articleService.saveOrUpdate(article);

		
		ArticlePattern artpattern = new ArticlePattern();
		artpattern.setUser(user);
		artpattern.setFormat(fnUServ.getFormatByUnitName("unité(s)"));
		artpattern.setName("Bouton");
		Set<Article>articles = new HashSet<Article>();
		artpattern.setArticles(articles);
		artPatServ.saveOrUpdate(artpattern);
		
		qOfArt.setMotherArticle(article);
		qOfArt.setUnit1(10);
		qOfArt.setProject(project);
		
		qOfArtService.createQofArt(qOfArt);
		
		listQofArt.add(qOfArt);
		System.out.println("1er article ds list");
		
		//2nd qOfArt

		QuantityOfArticle qOfArt2 = new QuantityOfArticle();
		Article article2 = new Article();
		article2.setName("Vichy bleu");
		article2.setAlias("coton, bleu foncé, largeur: 2m50");
		article2.setUser(user);
		articleService.saveOrUpdate(article2);


		
		ArticlePattern artpattern2 = new ArticlePattern();
		artpattern2.setUser(user);
		artpattern2.setFormat(fnUServ.getFormatByUnitName("cm"));
		artpattern2.setName("Tissu");
		Set<Article>articles2 = new HashSet<Article>();
		artpattern2.setArticles(articles2);
		artPatServ.saveOrUpdate(artpattern2);

		
		qOfArt2.setMotherArticle(article2);
		qOfArt2.setUnit1(200);
		qOfArt2.setProject(project);

		
		listQofArt.add(qOfArt2);
		System.out.println("2e article ds list");

		
		//3rd qOfArt
		QuantityOfArticle qOfArt3 = new QuantityOfArticle();
		Article article3 = new Article();
				article3.setName("Machine à coudre");
				article3.setAlias("Janome");
				article3.setUser(user);
				articleService.saveOrUpdate(article3);

				
				ArticlePattern artpattern3 = new ArticlePattern();
				artpattern3.setUser(user);
				artpattern3.setFormat(fnUServ.getFormatByUnitName("N/A"));
				artpattern3.setName("Outil");
				Set<Article>articles3 = new HashSet<Article>();
				artpattern3.setArticles(articles3);
				artPatServ.saveOrUpdate(artpattern3);

				article3.setArticlePattern(artpattern3);

				qOfArt3.setMotherArticle(article3);
				qOfArt3.setProject(project);

				
				listQofArt.add(qOfArt3);
				System.out.println("3e article ds list");

		
		return listQofArt;
	}

}
