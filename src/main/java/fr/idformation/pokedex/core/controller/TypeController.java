package fr.idformation.pokedex.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.pokedex.core.dto.TypeDTO;
import fr.idformation.pokedex.core.dto.mapper.TypeMapper;
import fr.idformation.pokedex.core.service.ITypeService;

@RestController
@RequestMapping("/type")
public class TypeController {

	/** service for types. */
	@Autowired
	private ITypeService typeService;

	@GetMapping("/")
	public List<TypeDTO> getAll() {
		return TypeMapper.typesToDtos(typeService.getAll());
	}

}
