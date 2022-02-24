package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Colonia;
import com.ivra.graphql.graphql.repository.ColoniaRepository;
import com.ivra.graphql.graphql.service.ColoniaService;

@Service
public class ColoniaServiceImpl implements ColoniaService {

	@Autowired
	private ColoniaRepository coloniaRepository;
	
	@Override
	public Colonia findById(final Long id){
		Optional<Colonia> colonia = coloniaRepository.findById(id);
		if(colonia.isPresent()) {
			return colonia.get();
		}
		throw new RuntimeException("No existe la colonia");
	}
	
	@Override
	public List<Colonia> findAll(final int registros){
		return coloniaRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public Colonia save(Colonia colonia) {
		return coloniaRepository.save(colonia);
	}
	
	@Override
	public Colonia update(Colonia colonia) {
		Colonia col = findById(colonia.getId());
		col.setDescripcion(colonia.getDescripcion());
		col.setFecha(colonia.getFecha());
		col.setClave0(colonia.getClave0());
		col.setClave1(colonia.getClave1());
		col.setClave2(colonia.getClave2());
		col.setClave3(colonia.getClave3());
		col.setClave4(colonia.getClave4());
		col.setClave5(colonia.getClave5());
		return coloniaRepository.save(col);
	}
	
	@Override
	public Colonia deleteById(Long id) {
		Colonia colonia = findById(id);
		coloniaRepository.delete(colonia);
		return colonia;
	}
}
