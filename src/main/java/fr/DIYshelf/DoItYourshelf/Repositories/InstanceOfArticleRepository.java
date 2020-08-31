package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.InstanceOfArticle;

public interface InstanceOfArticleRepository extends JpaRepository<InstanceOfArticle, Integer>{

}
