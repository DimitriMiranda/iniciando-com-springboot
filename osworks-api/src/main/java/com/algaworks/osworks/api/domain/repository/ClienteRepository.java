package com.algaworks.osworks.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.api.domain.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

	
	List <Cliente> findByNome(String nome);
	/*List <Cliente> findByNomeCotaining(String nome);*/
	Cliente  findByEmail(String email);
	
	
}
