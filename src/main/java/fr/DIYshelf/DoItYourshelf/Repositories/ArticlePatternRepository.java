package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.ArticlePattern;
import fr.DIYshelf.DoItYourshelf.Beans.User;

public interface ArticlePatternRepository extends JpaRepository<ArticlePattern, Integer>{

	@Query("select ap from ArticlePattern ap where ap.name = ?1")
	public ArticlePattern getArticlePatternByName (String name);

	@Query("select ap from ArticlePattern ap where ap.user.id = ?1")
	public List<ArticlePattern> findAllByUser(int userId);

	@Query("select ap from ArticlePattern ap where ap.name = ?1 and ap.user.id = ?2")
	public ArticlePattern getArticlePatternByNameandUser(String name, int id);
	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
