package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.DIYshelf.DoItYourshelf.Beans.Format;

public interface FormatRepository extends JpaRepository<Format, Integer>{

	@Query("select f from Format f where f.name = ?1")
	Format findByName(String formatName);

	@Query("select name from Format")
	List<String> findAllFormatName();

	@Query("select f from Format f where f.unitName = ?1")
	Format findByUnitName(String UnitName);


}
