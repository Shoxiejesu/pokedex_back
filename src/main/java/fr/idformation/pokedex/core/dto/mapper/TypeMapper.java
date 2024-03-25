package fr.idformation.pokedex.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.pokedex.core.domain.Type;
import fr.idformation.pokedex.core.dto.TypeDTO;

public class TypeMapper {

	/**
	 * Convert a List of type into a list of typeDTO.
	 *
	 * @param pTypes the list to convert
	 * @return the sibling DTO List of types
	 */
	public static List<TypeDTO> typesToDtos(final List<Type> pTypes) {
		List<TypeDTO> dtos = null;

		if (pTypes != null) {
			dtos = new ArrayList<>();
			for (Type type : pTypes) {
				dtos.add(typeToDto(type));
			}
		}

		return dtos;
	}

	/**
	 * Convert a Type into a TypeDTO.
	 *
	 * @param pType the type to convert
	 * @return the TypeDTO representation of the given Type
	 */
	public static TypeDTO typeToDto(final Type pType) {

		TypeDTO dto = null;

		if (pType != null) {
			dto = new TypeDTO();

			dto.setId(pType.getId());
			dto.setColor(pType.getColor());
		}

		return dto;
	}

}
