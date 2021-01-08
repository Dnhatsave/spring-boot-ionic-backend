package com.sydevelop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sydevelop.cursomc.domain.Categoria;
import com.sydevelop.cursomc.repositories.CategoriaRepository;
import com.sydevelop.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objecto nao encontrado! Id" + id
				+ "Tipo:" + Categoria.class.getName()));
	}

}
