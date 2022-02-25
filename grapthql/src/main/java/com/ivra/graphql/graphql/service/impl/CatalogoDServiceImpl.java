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
	
	@Autowired CatalogoDRepository catalogoDRepository;

	@Override
	public CatalogoD findById(Long id) {
		Optional<CatalogoD> cuentaOptional = catalogoDRepository.findById(id);

		if(cuentaOptional.isPresent()) {
			return cuentaOptional.get();
		}
		throw new NotFoundException("No existe la cuenta", "Cuenta");
	}

	@Override
	public CatalogoD save(CatalogoD catalogoD) {
		return catalogoDRepository.save(catalogoD);
	}

	@Override
	public CatalogoD deleteById(Long id) {
		CatalogoD cuenta =  findById(id);
		catalogoDRepository.delete(cuenta);
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
		return catalogoDRepository.save(catalogoDPersist);
	}

	@Override
	public List<CatalogoD> findAll(int limit) {
		return catalogoDRepository.findAll();
	}

}
