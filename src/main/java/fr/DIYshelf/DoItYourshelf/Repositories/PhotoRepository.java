package fr.DIYshelf.DoItYourshelf.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.DIYshelf.DoItYourshelf.Beans.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

}
