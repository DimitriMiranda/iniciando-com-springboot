package com.algaworks.osworks.api.domain.service;


import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.api.domain.exception.NegocioException;
import com.algaworks.osworks.api.domain.model.Cliente;
import com.algaworks.osworks.api.domain.model.OrdemServico;
import com.algaworks.osworks.api.domain.model.StatusOrdemServico;
import com.algaworks.osworks.api.domain.repository.ClienteRepository;
import com.algaworks.osworks.api.domain.repository.OrdemServicoRepository;

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
		 ordemServico.setDataAbertura(OffsetDateTime.now());
		 ordemServico.setStatus(StatusOrdemServico.ABERTA);
		 
		return ordemServicoRepository.save(ordemServico);
	}

}
