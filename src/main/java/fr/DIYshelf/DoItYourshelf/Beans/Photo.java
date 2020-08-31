package fr.DIYshelf.DoItYourshelf.Beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Photo extends Entitie{
	
	private String name;
	private String url;
	@ManyToOne
	private Project project;
	@ManyToOne
	private Article article;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	
	
}
