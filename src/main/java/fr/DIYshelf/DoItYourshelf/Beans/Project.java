package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import fr.DIYshelf.DoItYourshelf.Enum.ProjectType;

@Entity
public class Project extends Entitie{
    private String name;
    private ProjectType projectType;
    @OneToMany
    private List<Photo> photosProject;

    @OneToMany
    private List<InstanceOfArticle> articles;
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
	public List<InstanceOfArticle> getArticles() {
		return articles;
	}
	public void setArticles(List<InstanceOfArticle> articles) {
		this.articles = articles;
	}
	public List<BluePrint> getBluePrints() {
		return bluePrints;
	}
	public void setBluePrints(List<BluePrint> bluePrints) {
		this.bluePrints = bluePrints;
	}

   

    
}
