package fr.DIYshelf.DoItYourshelf.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.DIYshelf.DoItYourshelf.Beans.Role;
import fr.DIYshelf.DoItYourshelf.Enum.ERole;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
