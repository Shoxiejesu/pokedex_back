package fr.idformation.pokedex.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.pokedex.core.dto.PokemonDTO;
import fr.idformation.pokedex.core.dto.mapper.PokemonMapper;
import fr.idformation.pokedex.core.service.IPokemonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private IPokemonService pokemonService;

	@GetMapping("/")
	public List<PokemonDTO> getAll() {
		return PokemonMapper.pokemonsToDtos(pokemonService.getAllPokemons());
	}

	/**
	 * @param name an optional filter on the name
	 * @return all pokemons
	 */
	@GetMapping("/search")
	public List<PokemonDTO> getAll(@RequestParam final String name) {
		return PokemonMapper.pokemonsToDtos(pokemonService.getAllPokemonsFilteredByName(name));
	}

	/**
	 * Find a pokemon from its id.
	 *
	 * @param id the id of the pokemon
	 * @return athe pokemon with the given id
	 */
	@GetMapping("/{id}")
	public PokemonDTO getOne(@PathVariable("id") final Short id) {
		return PokemonMapper.pokemonToDto(pokemonService.getOne(id));
	}

	/**
	 * Create or update a pokemon.
	 *
	 * @param pokemon the pokemon as a PokemonDTO
	 * @return the updated pokemon
	 */
	@PostMapping("/")
	public PokemonDTO save(@RequestBody final PokemonDTO pokemon) {
		return PokemonMapper.pokemonToDto(pokemonService.save(PokemonMapper.dtoToEntity(pokemon)));
	}

	/**
	 * Delete a pokemon.
	 *
	 * @param id       the ID of the pokemon
	 * @param response the response used
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Short id, final HttpServletResponse response) {
		try {
			pokemonService.delete(id);
		} catch (IllegalStateException ise) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} catch (EntityNotFoundException enfe) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
