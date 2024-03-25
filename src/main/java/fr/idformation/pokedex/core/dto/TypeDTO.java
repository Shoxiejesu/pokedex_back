package fr.idformation.pokedex.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeDTO {

	/** the technical id. */
	private Short id;

	/** a color as a RRGGBB code. */
	private String color;

	/**
	 *
	 */
	public TypeDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Short pId) {
		this.id = pId;
	}

	/**
	 * @param pColor the color to set
	 */
	public void setColor(final String pColor) {
		this.color = pColor;
	}
}
