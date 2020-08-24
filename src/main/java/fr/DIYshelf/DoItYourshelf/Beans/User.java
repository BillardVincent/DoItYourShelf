package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User extends Entitie{
private String name;
private String password;
@OneToMany
private Set<Article> articles;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public Set<Article> getArticles() {
	return articles;
}
public void setArticles(Set<Article> articles) {
	this.articles = articles;
}
public User() {
	super();
}
public User(String name, String password, Set<Article> articles) {
	super();
	this.name = name;
	this.password = password;
	this.articles = articles;
}




}
