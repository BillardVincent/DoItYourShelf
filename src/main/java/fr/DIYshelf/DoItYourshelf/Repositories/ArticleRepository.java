package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	@Query("select a from Article a where a.name = ?1")
	public Article getArticleByName (String name);
	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
