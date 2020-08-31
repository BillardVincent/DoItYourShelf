package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.DIYshelf.DoItYourshelf.Beans.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
