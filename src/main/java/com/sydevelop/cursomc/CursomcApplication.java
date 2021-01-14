package com.sydevelop.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sydevelop.cursomc.domain.Categoria;
import com.sydevelop.cursomc.domain.Cidade;
import com.sydevelop.cursomc.domain.Cliente;
import com.sydevelop.cursomc.domain.Endereco;
import com.sydevelop.cursomc.domain.Estado;
import com.sydevelop.cursomc.domain.ItemPedido;
import com.sydevelop.cursomc.domain.Pagamento;
import com.sydevelop.cursomc.domain.PagamentoComBoleto;
import com.sydevelop.cursomc.domain.PagamentoComCartao;
import com.sydevelop.cursomc.domain.Pedido;
import com.sydevelop.cursomc.domain.Produto;
import com.sydevelop.cursomc.domain.enumns.EstadoPagamento;
import com.sydevelop.cursomc.domain.enumns.TipoCliente;
import com.sydevelop.cursomc.repositories.CategoriaRepository;
import com.sydevelop.cursomc.repositories.CidadeRepository;
import com.sydevelop.cursomc.repositories.ClienteRepository;
import com.sydevelop.cursomc.repositories.EnderecoRepository;
import com.sydevelop.cursomc.repositories.EstadoRepository;
import com.sydevelop.cursomc.repositories.ItemPedidoRepository;
import com.sydevelop.cursomc.repositories.PagamentoRepository;
import com.sydevelop.cursomc.repositories.PedidoRepository;
import com.sydevelop.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

		
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
