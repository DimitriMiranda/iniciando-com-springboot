package com.algaworks.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.model.StatusOrdemServico;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado") );
	     
		 ordemServico.setCliente(cliente);
		 ordemServico.setDataAbertura(LocalDateTime.now());
		 ordemServico.setStatus(StatusOrdemServico.ABERTA);
		 
		return ordemServicoRepository.save(ordemServico);
	}

}
