package com.ivra.graphql.graphql.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Banco;
import com.ivra.graphql.graphql.repository.BancoRepository;
import com.ivra.graphql.graphql.service.BancoService;

@Service
public class BancoServiceImpl implements BancoService {
	
	private BancoRepository bancoRepository;

	public BancoServiceImpl(BancoRepository bancoRepository) {
		this.bancoRepository = bancoRepository;
	}
	
	public Banco registrarBanco(final String nombre, final String clave, String fechaRegistro) {
		Optional<String> fecReg = Optional.ofNullable(fechaRegistro);
		Banco banco = new Banco(nombre, clave,  fecReg.isPresent() ? LocalDate.parse(fecReg.get()) : LocalDate.now());
		return bancoRepository.save(banco);
	}
	
	public Optional<Banco> banco(final int id){
		return bancoRepository.findById(id);
	}
	
	public List<Banco> bancos(final int registros){
		return bancoRepository.findAll().stream().limit(registros).collect(Collectors.toList());
	}

}
