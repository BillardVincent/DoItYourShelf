package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.DIYshelf.DoItYourshelf.Enum.ProjectType;

@Entity
public class Project extends Entitie{
    private String name;
    private boolean isStorage;
    private ProjectType projectType;
    @ManyToOne
    private User user;
    @OneToMany (mappedBy = "project")
    private List<Photo> photosProject;
    @ManyToMany
    private List<Project> Projects;
    @OneToMany (mappedBy = "project")
    private List<QuantityOfArticle> quantityOfArticles;
    @ManyToMany
    private List<BluePrint> bluePrints;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectType getProjectType() {
		return projectType;
	}
	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}
	public List<Photo> getPhotosProject() {
		return photosProject;
	}
	public void setPhotosProject(List<Photo> photosProject) {
		this.photosProject = photosProject;
	}
	public List<QuantityOfArticle> getQuantityOfArticles() {
		return quantityOfArticles;
	}
	public void setQuantityOfArticles(List<QuantityOfArticle> articles) {
		this.quantityOfArticles = articles;
	}
	public List<BluePrint> getBluePrints() {
		return bluePrints;
	}
	public void setBluePrints(List<BluePrint> bluePrints) {
		this.bluePrints = bluePrints;
	}
	public List<Project> getProjects() {
		return Projects;
	}
	public void setProjects(List<Project> projects) {
		Projects = projects;
	}
	public boolean isStorage() {
		return isStorage;
	}
	public void setStorage(boolean isStorage) {
		this.isStorage = isStorage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

   

    
}
