package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.model.Archivo;
import com.ivra.graphql.graphql.repository.ArchivoRepository;
import com.ivra.graphql.graphql.service.ArchivoService;
import com.ivra.graphql.graphql.service.LeerArchivoService;

@Service
public class ArchivoServiceImpl implements ArchivoService {
	
	@Autowired
	private ArchivoRepository archivoRepository;
	
	@Autowired
	private LeerArchivoService leerArchivoService;

	@Override
	public List<Archivo> cargarArchivos(){
		leerArchivoService.leerArchivo();
		return archivoRepository.findAll();
	}
	
	@Override
	public Archivo findById(Long id) {
		Optional<Archivo> archivo = archivoRepository.findById(id);
		if(archivo.isPresent()) {
			return archivo.get();
		}
		throw new RuntimeException("No existe el archivo");  
	}
	
	@Override
	public List<Archivo> findAll(final int registros){
		return archivoRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public Archivo save(Archivo archivo) {
		return archivoRepository.save(archivo);
	}
	
	@Override
	public Archivo update(Archivo archivo) {
		Archivo arc = findById(archivo.getId());
		arc.setNombre(archivo.getNombre());
		arc.setFechaCarga(archivo.getFechaCarga());
		return archivoRepository.save(arc);
	}
	
	@Override
	public Archivo deleteById(Long id) {
		Archivo archivo = findById(id);
		archivoRepository.delete(archivo);
		return archivo;
	}
}
