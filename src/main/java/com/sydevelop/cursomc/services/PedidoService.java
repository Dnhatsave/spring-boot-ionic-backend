package com.sydevelop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sydevelop.cursomc.domain.Pedido;
import com.sydevelop.cursomc.repositories.PedidoRepository;
import com.sydevelop.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objecto nao encontrado! Id" + id
				+ "Tipo:" + Pedido.class.getName()));
	}

}
