package com.sydevelop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sydevelop.cursomc.domain.Cliente;
import com.sydevelop.cursomc.repositories.ClienteRepository;
import com.sydevelop.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objecto nao encontrado! Id" + id
				+ "Tipo:" + Cliente.class.getName()));
	}

}
