package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;

public interface InstanceOfArticleRepository extends JpaRepository<QuantityOfArticle, Integer>{

}
