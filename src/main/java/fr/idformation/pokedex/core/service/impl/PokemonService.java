package fr.idformation.pokedex.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.pokedex.core.domain.Pokemon;
import fr.idformation.pokedex.core.repository.IPokemonRepository;
import fr.idformation.pokedex.core.service.IPokemonService;

@Service
public final class PokemonService implements IPokemonService {

	/** repository for the Pokemon. */
	@Autowired
	private IPokemonRepository pokemonRepo;

	@Override
	public List<Pokemon> getAllPokemons() {
		return pokemonRepo.findAll();
	}

	@Override
	public List<Pokemon> getAllPokemonsFilteredByName(final String name) {
		return pokemonRepo.findByNameStartingWith(name);
	}

	@Override
	public Pokemon getOne(final Short id) {
		return pokemonRepo.getReferenceById(id);
	}

	@Override
	public Pokemon save(final Pokemon pokemon) {
		return pokemonRepo.saveAndFlush(pokemon);
	}

	@Override
	public void delete(final Short id) {
		pokemonRepo.deleteById(id);
	}

}
