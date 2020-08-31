package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Rangement extends Entitie{

    private String room;
    private String pOfFurniture;
    private String shelf;
    private String place;
    @OneToMany
    private Set<BluePrint> blueprints;
    @OneToMany
    private Set<Article> articles;
    
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getpOfFurniture() {
		return pOfFurniture;
	}
	public void setpOfFurniture(String pOfFurniture) {
		this.pOfFurniture = pOfFurniture;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Set<BluePrint> getBlueprints() {
		return blueprints;
	}
	public void setBlueprints(Set<BluePrint> blueprints) {
		this.blueprints = blueprints;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

    

}
