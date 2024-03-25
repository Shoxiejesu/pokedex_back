package fr.idformation.pokedex.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.pokedex.core.domain.Pokemon;
import fr.idformation.pokedex.core.domain.Type;
import fr.idformation.pokedex.core.dto.PokemonDTO;

public class PokemonMapper {

	/**
	 *
	 * @param pokemons a List of Pokemon
	 * @return the List of Pokemon turned into its sibling List of PokemonDTOs
	 */
	public static List<PokemonDTO> pokemonsToDtos(final List<Pokemon> pokemons) {
		List<PokemonDTO> dtos = null;

		if ((pokemons != null)) {
			dtos = new ArrayList<>();

			for (Pokemon pokemon : pokemons) {
				dtos.add(pokemonToDto(pokemon));
			}
		}

		return dtos;
	}

	/**
	 *
	 * @param pokemon a Pokemon
	 * @return the Pokemon turned into its sibling PokemonDTO
	 */
	public static PokemonDTO pokemonToDto(final Pokemon pokemon) {
		PokemonDTO dto = null;

		if (pokemon != null) {
			dto = new PokemonDTO();

			dto.setId(pokemon.getId());
			dto.setCp(pokemon.getForce());
			dto.setHp(pokemon.getHealth());
			dto.setName(pokemon.getName());
			dto.setPicture(pokemon.getPicture());

			if (pokemon.getTypes() != null && !pokemon.getTypes().isEmpty()) {
				List<Short> typeIds = new ArrayList<>();

				for (Type type : pokemon.getTypes()) {
					typeIds.add(type.getId());
				}

				dto.setTypes(typeIds);
			}
		}

		return dto;
	}

	/**
	 * Create a Pokemon from a PokemonDTO.
	 *
	 * @param dto the dto used as a source
	 * @return a Pokemon filled with datas from dto
	 */
	public static Pokemon dtoToEntity(PokemonDTO dto) {
		Pokemon entity = null;

		if (dto != null) {
			entity = new Pokemon();
			entity.setId(dto.getId());
			entity.setPicture(dto.getPicture());
			entity.setForce(dto.getCp());
			entity.setHealth(dto.getHp());
			entity.setName(dto.getName());
			if (dto.getTypes() != null) {
				for (short id : dto.getTypes()) {
					entity.addType(new Type(id));
				}
			}

		}

		return entity;
	}

	public Boolean booleanMethod() {
		return null;
	}

}
