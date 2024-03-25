package fr.idformation.pokedex.core.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`type`")
public class Type {

	/** unique id of the type. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typ_id")
	private Short id;

	/** name of the type. */
	@Column(name = "typ_label")
	private String label;

	/** name of the type. */
	@Column(name = "typ_color")
	private String color;

	/** pokemons having the type. */
	@ManyToMany(mappedBy = "types")
	private Set<Pokemon> pokemons;

	/**
	 * Default constructor.
	 */
	public Type() {
		super();
	}

	/**
	 * Constructor with one parameter.
	 *
	 * @param pId an id
	 */
	public Type(final short pId) {
		super();
		this.id = pId;
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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param pLabel the label to set
	 */
	public void setLabel(final String pLabel) {
		this.label = pLabel;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param pColor the color to set
	 */
	public void setColor(final String pColor) {
		this.color = pColor;
	}

	/**
	 * @return the pokemons
	 */
	public Set<Pokemon> getPokemons() {
		return pokemons;
	}

	/**
	 * @param pPokemons the pokemons to set
	 */
	public void setPokemons(final Set<Pokemon> pPokemons) {
		this.pokemons = pPokemons;
	}

	/**
	 * Add a pokemon to pokemons.
	 *
	 * @param pokemon
	 */
	public void addPokemon(final Pokemon pokemon) {
		if (pokemons == null) {
			pokemons = new HashSet<>();
		}

		pokemons.add(pokemon);

	}

	/**
	 * remove a pokemon from pokemons.
	 *
	 * @param pokemon
	 */
	public void removePokemon(final Pokemon pokemon) {
		if (pokemons == null) {
			return;
		}

		pokemons.remove(pokemon);
	}

}
