package com.ivra.graphql.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivra.graphql.graphql.exception.NotFoundException;
import com.ivra.graphql.graphql.model.CatalogoT;
import com.ivra.graphql.graphql.repository.CatalogoTRepository;
import com.ivra.graphql.graphql.service.CatalogoTService;

@Service
public class CatalogoTServiceImpl implements CatalogoTService {

	@Autowired
	private CatalogoTRepository catalogoTRepository;
	
	@Override
	public CatalogoT findById(final Long processDate){
		Optional<CatalogoT> catalogoT = catalogoTRepository.findById(processDate);
		if(catalogoT.isPresent()) {
			return catalogoT.get();
		}
		throw new NotFoundException("No existe el catalogoT", "CatalogoT");
	}
	
	@Override
	public List<CatalogoT> findAll(final int registros){
		return catalogoTRepository.findAll(Pageable.ofSize(registros)).getContent();
	}
	
	@Override
	public CatalogoT save(CatalogoT catalogoT) {
		return catalogoTRepository.save(catalogoT);
	}
	
	@Override
	public CatalogoT update(CatalogoT catalogoT) {
		CatalogoT cat = findById(catalogoT.getProcessDate());
		cat.setHora(catalogoT.getHora());
		cat.setMoneda(catalogoT.getMoneda());
		cat.setPrecio(catalogoT.getPrecio());
		cat.setSiefore(catalogoT.getSiefore());
		cat.setValor(catalogoT.getValor());
		cat.setCol2(catalogoT.getCol2());
		cat.setCol3(catalogoT.getCol3());
		cat.setCol4(catalogoT.getCol4());
		cat.setCol5(catalogoT.getCol5());
		cat.setCol6(catalogoT.getCol6());
		cat.setCol7(catalogoT.getCol7());
		cat.setCol8(catalogoT.getCol8());
		cat.setCol9(catalogoT.getCol9());
		cat.setCveIva(catalogoT.getCveIva());
		cat.setTasaIva(catalogoT.getTasaIva());
		cat.setISR(catalogoT.getISR());
		cat.setIndice(catalogoT.getIndice());
		cat.setRegion(catalogoT.getRegion());
		cat.setPlazo(catalogoT.getPlazo());
		cat.setT_bruta(catalogoT.getT_bruta());
		cat.setLim_inf(catalogoT.getLim_inf());
		cat.setLim_sup(catalogoT.getLim_sup());
		cat.setDivMet(catalogoT.getDivMet());
		cat.setDenomin(catalogoT.getDenomin());
		cat.setVenta(catalogoT.getVenta());
		cat.setCveTc(catalogoT.getCveTc());
		cat.setCompra(catalogoT.getCompra());
		cat.setDiario(catalogoT.getDiario());
		cat.setMensual(catalogoT.getMensual());
		cat.setAnual(catalogoT.getAnual());
		return catalogoTRepository.save(cat);
	}
	
	@Override
	public CatalogoT deleteById(Long processDate) {
		CatalogoT catalogoT = findById(processDate);
		catalogoTRepository.delete(catalogoT);
		return catalogoT;
	}
}
