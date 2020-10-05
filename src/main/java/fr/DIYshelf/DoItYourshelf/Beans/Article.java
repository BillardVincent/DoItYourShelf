package fr.DIYshelf.DoItYourshelf.Beans;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Article extends Entitie{
    private String type;//(Tissu, boutons, outil…)
    private String name;
    private String alias;
   
	@ManyToOne
	private ArticlePattern articlePattern;

    @OneToMany(mappedBy = "motherArticle")
    private Set<QuantityOfArticle> instOfArt;
	@OneToMany(mappedBy = "article")
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

	

	public ArticlePattern getArticlePattern() {
		return articlePattern;
	}

	public void setArticlePattern(ArticlePattern articlePattern) {
		this.articlePattern = articlePattern;
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


	public Set<QuantityOfArticle> getInstOfArt() {
		return instOfArt;
	}

	public void setInstOfArt(Set<QuantityOfArticle> instOfArt) {
		this.instOfArt = instOfArt;
	}

	public Rangement getRangement() {
		return rangement;
	}

	public void setRangement(Rangement rangement) {
		this.rangement = rangement;
	}

	
	

	public Article() {
    }

	
}

