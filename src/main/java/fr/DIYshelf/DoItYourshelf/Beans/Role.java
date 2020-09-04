package fr.DIYshelf.DoItYourshelf.Beans;

import javax.persistence.*;

import fr.DIYshelf.DoItYourshelf.Enum.ERole;

@Entity
@Table(name = "roles")
public class Role extends Entitie{


	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}