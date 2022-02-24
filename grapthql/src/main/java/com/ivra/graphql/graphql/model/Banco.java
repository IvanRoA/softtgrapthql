package com.ivra.graphql.graphql.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nombre;
	@Column(name = "clave", nullable = false)
	private String clave;
	@Column
	private LocalDate fechaRegistro;
	
	public Banco() {
		super();
	}

	public Banco(String nombre, String clave, LocalDate fechaRegistro) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.fechaRegistro = fechaRegistro;
	}

	public Banco(Long id, String nombre, String clave, LocalDate fechaRegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.fechaRegistro = fechaRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
