package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.name = ?1")
	public User getUserByName (String name);
	
	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
