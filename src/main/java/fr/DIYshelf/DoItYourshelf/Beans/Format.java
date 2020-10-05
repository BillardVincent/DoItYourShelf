package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Format extends Entitie {

	private String name;
	private String unitName;
	private int nbDimension;
	private String unit;
	
	@OneToMany(mappedBy = "format")
	@JsonIgnore
	private Set<ArticlePattern> patterns;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public int getNbDimension() {
		return nbDimension;
	}
	public void setNbDimension(int nbDimension) {
		this.nbDimension = nbDimension;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Set<ArticlePattern> getPatterns() {
		return patterns;
	}
	public void setPatterns(Set<ArticlePattern> patterns) {
		this.patterns = patterns;
	}
	@Override
	public String toString() {
		return "Format [name=" + name + ", unit=" + unit + ", id=" + id + "]";
	}
	
	
	
}
