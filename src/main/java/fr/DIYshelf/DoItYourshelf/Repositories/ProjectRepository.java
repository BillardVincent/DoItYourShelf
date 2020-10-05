package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	@Query ("select p from Project p where p.name = ?1")
	Optional<Project> findByName(String name);

}
