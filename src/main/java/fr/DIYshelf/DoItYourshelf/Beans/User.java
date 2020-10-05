package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User extends Entitie{
private String username;
private String email;
private String password;
@OneToMany (mappedBy = "user")
private Set<Article> articles;
@OneToMany (mappedBy = "user")
private Set<Project> projects;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(	name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();
@OneToMany (mappedBy = "user")
private Set<ArticlePattern> artPattern;



public Set<Project> getProjects() {
	return projects;
}
public void setProjects(Set<Project> projects) {
	this.projects = projects;
}
public String getUsername() {
	return username;
}
public void setUsername(String name) {
	this.username = name;
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

public String getEmail() {
	return email;
}
public void setEmail(String eMail) {
	this.email = eMail;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

public Set<ArticlePattern> getArtPattern() {
	return artPattern;
}
public void setArtPattern(Set<ArticlePattern> artPattern) {
	this.artPattern = artPattern;
}
public User(String username, String email, String password) {
	this.username = username;
	this.email = email;
	this.password = password;
}
public User() {
	super();
}


}
