package com.ivra.graphql.graphql.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatalogoT implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long processDate;
	@Column
	private LocalTime hora;
	@Column
	private String moneda;
	@Column
	private BigDecimal precio;
	@Column
	private String siefore;
	@Column
	private String valor;
	@Column
	private String col2;
	@Column
	private String col3;
	@Column
	private String col4;
	@Column
	private String col5;
	@Column
	private String col6;
	@Column
	private String col7;
	@Column
	private String col8;
	@Column
	private String col9;
	@Column
	private String cveIva;
	@Column
	private BigDecimal tasaIva;
	@Column
	private BigDecimal ISR;
	@Column
	private String indice;
	@Column
	private String region;
	@Column
	private Integer plazo;
	@Column
	private BigDecimal t_bruta;
	@Column
	private String lim_inf;
	@Column
	private String lim_sup;
	@Column
	private String divMet;
	@Column
	private String denomin;
	@Column
	private BigDecimal venta;
	@Column
	private String cveTc;
	@Column
	private BigDecimal compra;
	@Column
	private String diario;
	@Column
	private String mensual;
	@Column
	private String anual;
	
	public CatalogoT() {
		super();
	}

	public CatalogoT(LocalTime hora, String moneda, BigDecimal precio, String siefore, String valor, String col2,
			String col3, String col4, String col5, String col6, String col7, String col8, String col9, String cveIva,
			BigDecimal tasaIva, BigDecimal ISR, String indice, String region, Integer plazo, BigDecimal t_bruta,
			String lim_inf, String lim_sup, String divMet, String denomin, BigDecimal venta, String cveTc,
			BigDecimal compra, String diario, String mensual, String anual) {
		super();
		this.hora = hora;
		this.moneda = moneda;
		this.precio = precio;
		this.siefore = siefore;
		this.valor = valor;
		this.col2 = col2;
		this.col3 = col3;
		this.col4 = col4;
		this.col5 = col5;
		this.col6 = col6;
		this.col7 = col7;
		this.col8 = col8;
		this.col9 = col9;
		this.cveIva = cveIva;
		this.tasaIva = tasaIva;
		this.ISR = ISR;
		this.indice = indice;
		this.region = region;
		this.plazo = plazo;
		this.t_bruta = t_bruta;
		this.lim_inf = lim_inf;
		this.lim_sup = lim_sup;
		this.divMet = divMet;
		this.denomin = denomin;
		this.venta = venta;
		this.cveTc = cveTc;
		this.compra = compra;
		this.diario = diario;
		this.mensual = mensual;
		this.anual = anual;
	}

	public CatalogoT(Long processDate, LocalTime hora, String moneda, BigDecimal precio, String siefore,
			String valor, String col2, String col3, String col4, String col5, String col6, String col7, String col8,
			String col9, String cveIva, BigDecimal tasaIva, BigDecimal ISR, String indice, String region, Integer plazo,
			BigDecimal t_bruta, String lim_inf, String lim_sup, String divMet, String denomin, BigDecimal venta,
			String cveTc, BigDecimal compra, String diario, String mensual, String anual) {
		super();
		this.processDate = processDate;
		this.hora = hora;
		this.moneda = moneda;
		this.precio = precio;
		this.siefore = siefore;
		this.valor = valor;
		this.col2 = col2;
		this.col3 = col3;
		this.col4 = col4;
		this.col5 = col5;
		this.col6 = col6;
		this.col7 = col7;
		this.col8 = col8;
		this.col9 = col9;
		this.cveIva = cveIva;
		this.tasaIva = tasaIva;
		this.ISR = ISR;
		this.indice = indice;
		this.region = region;
		this.plazo = plazo;
		this.t_bruta = t_bruta;
		this.lim_inf = lim_inf;
		this.lim_sup = lim_sup;
		this.divMet = divMet;
		this.denomin = denomin;
		this.venta = venta;
		this.cveTc = cveTc;
		this.compra = compra;
		this.diario = diario;
		this.mensual = mensual;
		this.anual = anual;
	}

	public Long getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Long processDate) {
		this.processDate = processDate;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getSiefore() {
		return siefore;
	}

	public void setSiefore(String siefore) {
		this.siefore = siefore;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public String getCol6() {
		return col6;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}

	public String getCol7() {
		return col7;
	}

	public void setCol7(String col7) {
		this.col7 = col7;
	}

	public String getCol8() {
		return col8;
	}

	public void setCol8(String col8) {
		this.col8 = col8;
	}

	public String getCol9() {
		return col9;
	}

	public void setCol9(String col9) {
		this.col9 = col9;
	}

	public String getCveIva() {
		return cveIva;
	}

	public void setCveIva(String cveIva) {
		this.cveIva = cveIva;
	}

	public BigDecimal getTasaIva() {
		return tasaIva;
	}

	public void setTasaIva(BigDecimal tasaIva) {
		this.tasaIva = tasaIva;
	}

	public BigDecimal getISR() {
		return ISR;
	}

	public void setISR(BigDecimal iSR) {
		ISR = iSR;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public BigDecimal getT_bruta() {
		return t_bruta;
	}

	public void setT_bruta(BigDecimal t_bruta) {
		this.t_bruta = t_bruta;
	}

	public String getLim_inf() {
		return lim_inf;
	}

	public void setLim_inf(String lim_inf) {
		this.lim_inf = lim_inf;
	}

	public String getLim_sup() {
		return lim_sup;
	}

	public void setLim_sup(String lim_sup) {
		this.lim_sup = lim_sup;
	}

	public String getDivMet() {
		return divMet;
	}

	public void setDivMet(String divMet) {
		this.divMet = divMet;
	}

	public String getDenomin() {
		return denomin;
	}

	public void setDenomin(String denomin) {
		this.denomin = denomin;
	}

	public BigDecimal getVenta() {
		return venta;
	}

	public void setVenta(BigDecimal venta) {
		this.venta = venta;
	}

	public String getCveTc() {
		return cveTc;
	}

	public void setCveTc(String cveTc) {
		this.cveTc = cveTc;
	}

	public BigDecimal getCompra() {
		return compra;
	}

	public void setCompra(BigDecimal compra) {
		this.compra = compra;
	}

	public String getDiario() {
		return diario;
	}

	public void setDiario(String diario) {
		this.diario = diario;
	}

	public String getMensual() {
		return mensual;
	}

	public void setMensual(String mensual) {
		this.mensual = mensual;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
