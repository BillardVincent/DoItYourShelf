package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BluePrint extends Entitie{

    private String name;
    private String origin;
    @ManyToOne
    private Rangement rangement;
    @ManyToMany
    private Set<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Rangement getRangement() {
        return rangement;
    }

    public void setRangement(Rangement rangement) {
        this.rangement = rangement;
    }


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    
}
