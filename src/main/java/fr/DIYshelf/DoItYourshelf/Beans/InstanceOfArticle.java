package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import fr.DIYshelf.DoItYourshelf.Enum.Units;

@Entity
public class InstanceOfArticle extends Entitie {
	
	@ManyToOne
	private Article motherArticle;
	@ManyToOne
	private Project project;
	private int unit1;
    private int unit2;// (fac.)
    private int unit3;// (fac.)
	private int unit4;// (fac.)
	public Article getMotherArticle() {
		return motherArticle;
	}
	public void setMotherArticle(Article motherArticle) {
		this.motherArticle = motherArticle;
	}
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getUnit1() {
		return unit1;
	}
	public void setUnit1(int unit1) {
		this.unit1 = unit1;
	}
	public int getUnit2() {
		return unit2;
	}
	public void setUnit2(int unit2) {
		this.unit2 = unit2;
	}
	public int getUnit3() {
		return unit3;
	}
	public void setUnit3(int unit3) {
		this.unit3 = unit3;
	}
	public int getUnit4() {
		return unit4;
	}
	public void setUnit4(int unit4) {
		this.unit4 = unit4;
	}
	

	
	
	
}
