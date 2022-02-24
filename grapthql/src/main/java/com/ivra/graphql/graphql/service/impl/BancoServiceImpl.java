package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.repository.BancoRepository;
import com.ivra.graphql.graphql.service.BancoService;

@Service
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Override
	public Banco findById(final Long id){
		Optional<Banco> banco = bancoRepository.findById(id);
		if(banco.isPresent()) {
			return banco.get();
		}
		throw new NotFoundException("No existe el banco","Banco");
	}
	
	@Override
	public List<Banco> findAll(final int registros){
		return bancoRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public Banco save(Banco banco) {
		return bancoRepository.save(banco);
	}
	
	@Override
	public Banco update(Banco banco) {
		Banco ban = findById(banco.getId());
		ban.setNombre(banco.getNombre());
		ban.setClave(banco.getClave());
		ban.setFechaRegistro(banco.getFechaRegistro());
		return bancoRepository.save(ban);
	}
	
	@Override
	public Banco deleteById(Long id) {
		Banco banco = findById(id);
		bancoRepository.delete(banco);
		return banco;
	}
}
