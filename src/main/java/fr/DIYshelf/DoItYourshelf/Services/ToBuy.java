package fr.DIYshelf.DoItYourshelf.Services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.User;

public class ToBuy {

	@Autowired
	InstanceOfArticleService instOfArtServ;
	@Autowired
	ArticleService articleService;
	@Autowired
	UserService userService;

	public Set<Article> generateToBuyList(User user) {
		// je créé une liste d'article, qui ne contiendront qu'une seule instance d'art
		Set<Article> artsToBuy = new HashSet<Article>();
		//Recup la list d'articles de l'utilisateur
		Optional<User> optuser = userService.getUserByName(user.getUsername());
		User user_DB = optuser.orElseThrow(() -> new RuntimeException("Error: User not found."));
		Set<Article> UserArticle = user_DB.getArticles();
		// Pour chaque article...
		
		for (Article article : UserArticle) {
			// préparation: objets renvoyés:
			// je créé un article qui n'aura qu'une seule instOfArt
			Article artForList = new Article();
			// La liste sera limité à 1 instance (qté totale)
			Set<QuantityOfArticle> listInstArtToBuy = new HashSet<QuantityOfArticle>();
			
			
			// je reprends toutes les instances de l'article de l'utilisateur
			Set<QuantityOfArticle> listOfInst = article.getInstOfArt();
			
			// je crée une instance qui sera unique, qui additionne ttes les instances répertoriées
			QuantityOfArticle sumOfInstances = new QuantityOfArticle();

			for (QuantityOfArticle instanceOfArticle : listOfInst) {
				int inOrOut = -1;
				// si l'article est dans un projet, il est consommé (soustractrion) sinon, c'est du stock (addition)
				if (instanceOfArticle.getProject() == null) {
					inOrOut = 1;
				}
				sumOfInstances.setUnit1(sumOfInstances.getUnit1() + (instanceOfArticle.getUnit1()) * inOrOut);
				sumOfInstances.setUnit2(sumOfInstances.getUnit2() + (instanceOfArticle.getUnit2()) * inOrOut);
				sumOfInstances.setUnit3(sumOfInstances.getUnit3() + (instanceOfArticle.getUnit3()) * inOrOut);
				sumOfInstances.setUnit4(sumOfInstances.getUnit4() + (instanceOfArticle.getUnit4()) * inOrOut);
				
				

			}
			//j'ajoute l'instance unique (somme) à la liste.
			listInstArtToBuy.add(sumOfInstances);
			// j'ajoute la liste d'instance (contenant une seule instance) à l'article
			artForList.setInstOfArt(listInstArtToBuy);
			// j'ajoute l'article avec une unique instance (sommée) à la liste d'articles qui sera renvoyée
			artsToBuy.add(artForList);
		}

		return artsToBuy;
	};

}
