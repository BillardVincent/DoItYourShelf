package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
