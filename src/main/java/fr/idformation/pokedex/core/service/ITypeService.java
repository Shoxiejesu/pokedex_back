package fr.idformation.pokedex.core.service;

import java.util.List;

import fr.idformation.pokedex.core.domain.Type;

public interface ITypeService {

	/**
	 * @return all known types
	 */
	List<Type> getAll();

}
