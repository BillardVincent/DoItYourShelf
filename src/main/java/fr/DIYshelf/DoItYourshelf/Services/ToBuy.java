package fr.DIYshelf.DoItYourshelf.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.InstanceOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.User;

public class ToBuy {
	
	@Autowired
	InstanceOfArticleService instOfArtServ;
	@Autowired
	ArticleService articleService;
	@Autowired
	UserService userService;
	
	public Set<Article> generateToBuyList(User user) {
		Set<Article> list = new HashSet<Article>();
		Set<Article> UserArticle = userService.getUserByName(user.getName()).getArticles();
		for (Article article : UserArticle) {
			Article artForList = new Article();
			Set<InstanceOfArticle> listOfInst= article.getInstOfArt();
			InstanceOfArticle sumOfInstances = new InstanceOfArticle();
			sumOfInstances.setMotherArticle(article);
			for (InstanceOfArticle instanceOfArticle : listOfInst) {
				int inOrOut = -1;
				if (instanceOfArticle.getProject() == null) {
					inOrOut = 1;
			}
				sumOfInstances.setUnit1(sumOfInstances.getUnit1() + (instanceOfArticle.getUnit1())*inOrOut); 
				sumOfInstances.setUnit2(sumOfInstances.getUnit2() + (instanceOfArticle.getUnit2())*inOrOut); 
				sumOfInstances.setUnit3(sumOfInstances.getUnit3() + (instanceOfArticle.getUnit3())*inOrOut); 
				sumOfInstances.setUnit4(sumOfInstances.getUnit4() + (instanceOfArticle.getUnit4())*inOrOut); 
				listOfInst.add(sumOfInstances);
				artForList.setInstOfArt(listOfInst);
				}

			list.add(artForList);

		}
		
		
		return list;
	};
	
	
	

}
