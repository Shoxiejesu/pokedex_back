package fr.idformation.pokedex.security.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	/** technical ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Name of the role. */
	@Enumerated(EnumType.STRING)
	private RoleName name;

	/** default constructor. */
	public Role() {
	}

	/**
	 * constructor from a rolename.
	 *
	 * @param pName a rolename
	 */
	public Role(final RoleName pName) {
		this.name = pName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the rolename
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Integer pId) {
		this.id = pId;
	}

	/**
	 * @param pName the rolename to set
	 */
	public void setName(final RoleName pName) {
		this.name = pName;
	}
}
