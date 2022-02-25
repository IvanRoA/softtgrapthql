package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.CatalogoD;
import com.ivra.graphql.graphql.repository.CatalogoDRepository;
import com.ivra.graphql.graphql.service.CatalogoDService;

@Service
public class CatalogoDServiceImpl implements CatalogoDService{
	
	@Autowired CatalogoDRepository cuentaRepository;

	@Override
	public CatalogoD findById(Long id) {
		Optional<CatalogoD> catalogoDOptional = cuentaRepository.findById(id);
		if(catalogoDOptional.isPresent()) {
			return catalogoDOptional.get();
		}
		throw new NotFoundException("No existe la cuenta", "Cuenta");
	}

	@Override
	public CatalogoD save(CatalogoD catalogoD) {
		return cuentaRepository.save(catalogoD);
	}

	@Override
	public CatalogoD deleteById(Long id) {
		CatalogoD cuenta =  findById(id);
		cuentaRepository.delete(cuenta);
		return cuenta;
	}

	@Override
	public CatalogoD update(CatalogoD catalogoD) {
		CatalogoD catalogoDPersist = findById(catalogoD.getId());
		catalogoDPersist.setProcessDate(catalogoD.getProcessDate());
		catalogoDPersist.setRelCatId(catalogoD.getRelCatId());
		catalogoDPersist.setFullDesc(catalogoD.getFullDesc());
		catalogoDPersist.setShortDesc(catalogoD.getShortDesc());
		catalogoDPersist.setScreenDesc(catalogoD.getScreenDesc());
		catalogoDPersist.setAbbreviation(catalogoD.getAbbreviation());
		return cuentaRepository.save(catalogoDPersist);
	}

	@Override
	public List<CatalogoD> findAll(int limit) {
		return cuentaRepository.findAll();
	}

}
