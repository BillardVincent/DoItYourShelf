package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;

public interface ArticlePatternRepository extends JpaRepository<ArticlePattern, Integer>{

	@Query("select ap from ArticlePattern ap where ap.name = ?1")
	public ArticlePattern getArticlePatternByName (String name);

	@Query("select ap from ArticlePattern ap where ap.user.id = ?1")
	public List<ArticlePattern> findAllByUser(int userId);
	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
