package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.username = ?1")
	public Optional<User> getUserByName (String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	
	// TO DO
		// Page<Article> findByBodyContaining(String kw, Pageable p);
}
