package fr.idformation.pokedex.core.service;

import java.util.List;

import fr.idformation.pokedex.core.domain.Pokemon;

public interface IPokemonService {

	/**
	 *
	 * @return all known pokemons
	 */

	List<Pokemon> getAllPokemons();

	/**
	 *
	 * @param name a filter
	 * @return all pokemon whose name starts with the given name
	 */
	List<Pokemon> getAllPokemonsFilteredByName(String name);

	/**
	 * Find a pokemon from its id.
	 *
	 * @param id the id of the pokemon
	 * @return athe pokemon with the given id
	 */
	Pokemon getOne(Short id);

	/**
	 * create or update a pokemon.
	 *
	 * @param pokemon
	 * @return the updated pokemon
	 */
	Pokemon save(Pokemon pokemon);

	/**
	 * delete a pokemon based on its id.
	 *
	 * @param id the id of the pokemon to delete
	 */
	void delete(Short id);

}
