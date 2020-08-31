package fr.DIYshelf.DoItYourshelf.Beans;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.DIYshelf.DoItYourshelf.Enum.Formats;
import fr.DIYshelf.DoItYourshelf.Enum.Units;

@Entity
public class Article extends Entitie{
    private String type;//(Tissu, boutons, outil…)
    private String name;
    private String alias;
    private Formats format; //(longueur, surface, volume unités boite NonComptable)
    private Formats format2; // (fac.) (longueur, surface, volume, unité)
    private Units unit1;
    private Units unit2;// (fac.)
    private Units unit3;// (fac.)
	private Units unit4;// (fac.)
    @OneToMany
    private Set<InstanceOfArticle> instOfArt;
	@OneToMany
	private Set<Photo> photos;// (URL)
	private Double price;
	private String placeOfBuying;
	@ManyToOne
	private Rangement rangement;
	@ManyToOne
	private User user;

  
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

  

   
    public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPlaceOfBuying() {
        return placeOfBuying;
    }

    public void setPlaceOfBuying(String placeOfBuying) {
        this.placeOfBuying = placeOfBuying;
    }


	public Set<InstanceOfArticle> getInstOfArt() {
		return instOfArt;
	}

	public void setInstOfArt(Set<InstanceOfArticle> instOfArt) {
		this.instOfArt = instOfArt;
	}

	public Rangement getRangement() {
		return rangement;
	}

	public void setRangement(Rangement rangement) {
		this.rangement = rangement;
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

	public Article() {
    }
}
