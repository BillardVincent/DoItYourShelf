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
@OneToMany
private Set<Article> articles;
@OneToMany
private Set<Project> projects;
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(	name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();




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
public User() {
	super();
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


public User(String username, String email, String password) {
	this.username = username;
	this.email = email;
	this.password = password;
}

}
