package fr.DIYshelf.DoItYourshelf.ElementsMock;

import java.util.HashSet;
import java.util.Set;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;

public class InstOfArticleRandGen {

	private static int nbOfInst;

	public QuantityOfArticle InstOfArtMocked(String var) {
		QuantityOfArticle instOfArtMocked = new QuantityOfArticle();
		instOfArtMocked.setUnit1(nbOfInst);
		nbOfInst++;
		return instOfArtMocked;
	}

	public Set<QuantityOfArticle> ListInstOfArtMocked(int nInstOfArt) {
		Set<QuantityOfArticle> instOfArtMockedList = new HashSet<QuantityOfArticle>();
		for (int i = 0; i < nInstOfArt; i++) {
			QuantityOfArticle instOfArt = InstOfArtMocked(String.valueOf(i));
			instOfArtMockedList.add(instOfArt);
		}
		return instOfArtMockedList;
	}

}
