package com.ivra.graphql.graphql.resolvers;

import com.ivra.graphql.graphql.model.CatalogoT;

public interface CatalogoTMutationResolver {

	CatalogoT saveCatalogoT(String hora, String moneda, String precio, String siefore, String valor, String col2,
			String col3, String col4, String col5, String col6, String col7, String col8, String col9, String cveIva,
			String tasaIva, String ISR, String indice, String region, Integer plazo, String t_bruta, String lim_inf,
			String lim_sup, String divMet, String denomin, String venta, String cveTc, String compra, String diario,
			String mensual, String anual);

	CatalogoT deleteCatalogoT(Long processDate);

	CatalogoT updateCatalogoT(Long processDate, String hora, String moneda, String precio, String siefore, String valor,
			String col2, String col3, String col4, String col5, String col6, String col7, String col8, String col9,
			String cveIva, String tasaIva, String ISR, String indice, String region, Integer plazo, String t_bruta,
			String lim_inf, String lim_sup, String divMet, String denomin, String venta, String cveTc, String compra,
			String diario, String mensual, String anual);

}
