package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	@Query("select a from Article a where a.name = ?1")
	public Article getArticleByName (String name);

	@Query("select a from Article a where a.user.id = ?1")
	public List<Article> findAllByUser(int userId);
	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
