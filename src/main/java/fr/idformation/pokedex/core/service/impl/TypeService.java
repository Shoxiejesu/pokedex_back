package fr.idformation.pokedex.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.pokedex.core.domain.Type;
import fr.idformation.pokedex.core.repository.ITypeRepository;
import fr.idformation.pokedex.core.service.ITypeService;

@Service
public final class TypeService implements ITypeService {

	/** repository for the types. */
	@Autowired
	private ITypeRepository typeRepo;

	@Override
	public List<Type> getAll() {
		return typeRepo.findAll();
	}

}
