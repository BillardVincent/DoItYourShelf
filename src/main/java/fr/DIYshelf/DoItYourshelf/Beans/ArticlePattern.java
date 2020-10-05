package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ArticlePattern extends Entitie{

	private String name;
	@ManyToOne
	 private Format format; //(longueur, surface, volume unités boite NonComptable)
	   
		@OneToMany(mappedBy = "articlePattern")
		private Set<Article> articles;
		@ManyToOne
		private User user;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Format getFormat() {
			return format;
		}
		public void setFormat(Format format) {
			this.format = format;
		
		}
		public Set<Article> getArticles() {
			return articles;
		}
		public void setArticles(Set<Article> articles) {
			this.articles = articles;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		
		
}
