package com.sydevelop.cursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sydevelop.cursomc.domain.ItemPedido;
import com.sydevelop.cursomc.domain.PagamentoComBoleto;
import com.sydevelop.cursomc.domain.Pedido;
import com.sydevelop.cursomc.domain.enumns.EstadoPagamento;
import com.sydevelop.cursomc.repositories.ItemPedidoRepository;
import com.sydevelop.cursomc.repositories.PagamentoRepository;
import com.sydevelop.cursomc.repositories.PedidoRepository;
import com.sydevelop.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	

	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow( ()-> new ObjectNotFoundException("Objecto nao encontrado! Id" + id
				+ "Tipo:" + Pedido.class.getName()));
	}

	 @Transactional
	 public Pedido insert(Pedido obj) {
			obj.setId(null);
			obj.setInstate(new Date());
			obj.setCliente(clienteService.find(obj.getCliente().getId()));
			obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
			obj.getPagamento().setPedido(obj);
			if (obj.getPagamento() instanceof PagamentoComBoleto) {
				PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
				boletoService.preencherPagamentoComBoleto(pagto, obj.getInstate());
			}
			obj = repo.save(obj);
			pagamentoRepository.save(obj.getPagamento());
			for (ItemPedido ip : obj.getItens()) {
				ip.setDesconto(0.0);
				ip.setProduto(produtoService.find(ip.getProduto().getId()));
				ip.setPreco(ip.getProduto().getPreco());
				ip.setPedido(obj);
			}
			
			itemPedidoRepository.saveAll(obj.getItens());
			emailService.sendOrderConfirmationEmail(obj);
			
			return obj;
		}

}
