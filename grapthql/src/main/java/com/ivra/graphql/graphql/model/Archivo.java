package com.ivra.graphql.graphql.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archivo {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "fechaCarga", nullable = false)
	private LocalDate fechaCarga;

	public Archivo() {
		super();
	}

	public Archivo(String nombre, LocalDate fechaCarga) {
		super();
		this.nombre = nombre;
		this.fechaCarga = fechaCarga;
	}

	public Archivo(Long id, String nombre, LocalDate fechaCarga) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCarga = fechaCarga;
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

	public LocalDate getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(LocalDate fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

}
