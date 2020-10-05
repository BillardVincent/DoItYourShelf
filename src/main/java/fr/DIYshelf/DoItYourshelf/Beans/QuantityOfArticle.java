package fr.DIYshelf.DoItYourshelf.Beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class QuantityOfArticle extends Entitie {
	
	@ManyToOne
	private Article motherArticle;
	@ManyToOne
	private Project project;
	private double unit1;
    private double unit2;// (fac.)
    private double unit3;// (fac.)
	
	
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
	public double getUnit1() {
		return unit1;
	}
	public void setUnit1(double unit1) {
		this.unit1 = unit1;
	}
	public double getUnit2() {
		return unit2;
	}
	public void setUnit2(double unit2) {
		this.unit2 = unit2;
	}
	public double getUnit3() {
		return unit3;
	}
	public void setUnit3(double unit3) {
		this.unit3 = unit3;
	}
	@Override
	public String toString() {
		return "InstanceOfArticle [motherArticle=" + motherArticle + ", project=" + project + ", unit1=" + unit1
				+ ", unit2=" + unit2 + ", unit3=" + unit3 + "]";
	}
	

	
	
	
}
