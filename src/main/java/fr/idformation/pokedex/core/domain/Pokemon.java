package fr.idformation.pokedex.core.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	/** unique Id of a pokemon. */
	@Id
	@Column(name = "pok_id")
	private Short id;

	/** name of the pokemon. */
	@Column(name = "pok_name")
	private String name;

	/** combat point of the pokemon. */
	@Column(name = "pok_cp")
	private Integer force;

	/** health point of the pokemon. */
	@Column(name = "pok_hp")
	private Short health;

	/** url for retrieving the picture of the pokemon. */
	@Column(name = "pok_picture")
	private String picture;

	/** types of the pokemon. */
	@ManyToMany
	@JoinTable(name = "pokemon_type", joinColumns = { @JoinColumn(name = "pok_id") }, inverseJoinColumns = {
			@JoinColumn(name = "typ_id") })
	private Set<Type> types;

	/**
	 * Default constructor.
	 */
	public Pokemon() {
		super();
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Short pId) {
		this.id = pId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param pName the name to set
	 */
	public void setName(final String pName) {
		this.name = pName;
	}

	/**
	 * @return the force
	 */
	public Integer getForce() {
		return force;
	}

	/**
	 * @param pForce the force to set
	 */
	public void setForce(final Integer pForce) {
		this.force = pForce;
	}

	/**
	 * @return the health
	 */
	public Short getHealth() {
		return health;
	}

	/**
	 * @param pHealth the health to set
	 */
	public void setHealth(final Short pHealth) {
		this.health = pHealth;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param pPicture the picture to set
	 */
	public void setPicture(final String pPicture) {
		this.picture = pPicture;
	}

	/**
	 * @return the types
	 */
	public Set<Type> getTypes() {
		return types;
	}

	/**
	 * @param pTypes the types to set
	 */
	public void setTypes(final Set<Type> pTypes) {
		this.types = pTypes;
	}

	/**
	 * Add a type to the pokemon.
	 *
	 * @param type the type to add
	 */
	public void addType(final Type type) {
		if (types == null) {
			types = new HashSet<>();
		}

		type.addPokemon(this);
		types.add(type);

	}

	/**
	 * remove a type from the pokemon.
	 *
	 * @param type the type to remove
	 */
	public void removeType(final Type type) {
		if (types == null) {
			return;
		}

		types.remove(type);
		type.removePokemon(this);

	}

}
