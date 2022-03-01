package com.ivra.graphql.graphql.resolvers.impl;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivra.graphql.graphql.model.CatalogoT;
import com.ivra.graphql.graphql.resolvers.CatalogoTMutationResolver;
import com.ivra.graphql.graphql.service.CatalogoTService;

@Component
public class CatalogoTMutationResolverImpl implements CatalogoTMutationResolver {

	@Autowired
	private CatalogoTService coloniaService;

	@Override
	public CatalogoT saveCatalogoT(String hora, String moneda, String precio, String siefore, String valor, String col2,
			String col3, String col4, String col5, String col6, String col7, String col8, String col9, String cveIva,
			String tasaIva, String ISR, String indice, String region, Integer plazo, String t_bruta, String lim_inf,
			String lim_sup, String divMet, String denomin, String venta, String cveTc, String compra, String diario,
			String mensual, String anual) {
		Optional<String> h = Optional.ofNullable(hora);
		return coloniaService.save(new CatalogoT(h.isPresent() ? LocalTime.parse(h.get()) : LocalTime.now(),
				moneda, new BigDecimal(precio), siefore, valor, col2, col3, col4, col5, col6, col7,
				col8, col9, cveIva, new BigDecimal(tasaIva), new BigDecimal(ISR), indice, region, plazo,
				new BigDecimal(t_bruta), lim_inf, lim_sup, divMet, denomin, new BigDecimal(venta), cveTc, new BigDecimal(compra),
				diario, mensual, anual));
	}

	@Override
	public CatalogoT deleteCatalogoT(Long id) {
		return coloniaService.deleteById(id);
	}

	@Override
	public CatalogoT updateCatalogoT(Long processDate, String hora, String moneda, String precio, String siefore,
			String valor, String col2, String col3, String col4, String col5, String col6, String col7, String col8,
			String col9, String cveIva, String tasaIva, String ISR, String indice, String region, Integer plazo,
			String t_bruta, String lim_inf, String lim_sup, String divMet, String denomin, String venta, String cveTc,
			String compra, String diario, String mensual, String anual) {
		Optional<String> h = Optional.ofNullable(hora);
		return coloniaService.update(new CatalogoT(processDate,
				h.isPresent() ? LocalTime.parse(h.get()) : LocalTime.now(), moneda,
				new BigDecimal(precio), siefore, valor, col2, col3, col4, col5, col6, col7, col8, col9, cveIva,
				new BigDecimal(tasaIva), new BigDecimal(ISR), indice, region, plazo, new BigDecimal(t_bruta), lim_inf,
				lim_sup, divMet, denomin, new BigDecimal(venta), cveTc, new BigDecimal(compra), diario, mensual, anual));
	}
}
