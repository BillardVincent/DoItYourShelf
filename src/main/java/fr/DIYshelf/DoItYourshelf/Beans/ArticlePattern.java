package fr.DIYshelf.DoItYourshelf.Beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.DIYshelf.DoItYourshelf.Enum.Formats;
import fr.DIYshelf.DoItYourshelf.Enum.Units;

@Entity
public class ArticlePattern extends Entitie{

	private String name;
	 private Formats format; //(longueur, surface, volume unités boite NonComptable)
	    private Formats format2; // (fac.) (longueur, surface, volume, unité)
	    private Units unit1;
	    private Units unit2;// (fac.)
	    private Units unit3;// (fac.)
		private Units unit4;// (fac.)
		@OneToMany
		private Set<Article> articles;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Formats getFormat() {
			return format;
		}
		public void setFormat(Formats format) {
			this.format = format;
		}
		public Formats getFormat2() {
			return format2;
		}
		public void setFormat2(Formats format2) {
			this.format2 = format2;
		}
		public Units getUnit1() {
			return unit1;
		}
		public void setUnit1(Units unit1) {
			this.unit1 = unit1;
		}
		public Units getUnit2() {
			return unit2;
		}
		public void setUnit2(Units unit2) {
			this.unit2 = unit2;
		}
		public Units getUnit3() {
			return unit3;
		}
		public void setUnit3(Units unit3) {
			this.unit3 = unit3;
		}
		public Units getUnit4() {
			return unit4;
		}
		public void setUnit4(Units unit4) {
			this.unit4 = unit4;
		}
		public Set<Article> getArticles() {
			return articles;
		}
		public void setArticles(Set<Article> articles) {
			this.articles = articles;
		}
		
		
		
}
