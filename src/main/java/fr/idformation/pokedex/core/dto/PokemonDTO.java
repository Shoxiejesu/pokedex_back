package fr.idformation.pokedex.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonDTO {

	/** the id. */
	private Short id;

	/** the pokemon name. */
	private String name;

	/** the health. */
	private Short hp;

	/** the force. */
	private Integer cp;

	/** an URL for the picture. */
	private String picture;

	/** a list of type ids. */
	private List<Short> types;

	/**
	 *
	 */
	public PokemonDTO() {
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
	 * @return the hp
	 */
	public Short getHp() {
		return hp;
	}

	/**
	 * @param pHp the hp to set
	 */
	public void setHp(final Short pHp) {
		this.hp = pHp;
	}

	/**
	 * @return the cp
	 */
	public Integer getCp() {
		return cp;
	}

	/**
	 * @param pCp the cp to set
	 */
	public void setCp(final Integer pCp) {
		this.cp = pCp;
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
	public List<Short> getTypes() {
		return types;
	}

	/**
	 * @param pTypes the types to set
	 */
	public void setTypes(final List<Short> pTypes) {
		this.types = pTypes;
	}

}
