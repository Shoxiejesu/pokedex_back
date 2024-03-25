package fr.idformation.pokedex.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.pokedex.core.domain.Pokemon;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon, Short> {

	/**
	 *
	 * @param name a filter
	 * @return all pokemons whose name starts with the given name
	 */
	List<Pokemon> findByNameStartingWith(String name);

}
