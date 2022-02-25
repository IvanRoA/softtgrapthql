package com.ivra.graphql.graphql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 3409223565395875014L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroCuenta;
	
	private String clave;

	public Cuenta() {
		super();
	}

	public Cuenta(String numeroCuenta, String clave) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.clave = clave;
	}

	public Cuenta(Long id, String numeroCuenta, String clave) {
		super();
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.clave = clave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
