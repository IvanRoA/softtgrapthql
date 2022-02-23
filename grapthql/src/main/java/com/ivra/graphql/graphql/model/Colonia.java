package com.ivra.graphql.graphql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colonia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Column
	private String clave0;
	@Column
	private String clave1;
	@Column
	private String clave2;
	@Column
	private String clave3;
	@Column
	private String clave4;
	@Column
	private String clave5;
	@Column
	private int fecha;
	
	public Colonia() {
		super();
	}

	public Colonia(String descripcion, String clave0, String clave1, String clave2, String clave3, String clave4,
			String clave5, int fecha) {
		super();
		this.descripcion = descripcion;
		this.clave0 = clave0;
		this.clave1 = clave1;
		this.clave2 = clave2;
		this.clave3 = clave3;
		this.clave4 = clave4;
		this.clave5 = clave5;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClave0() {
		return clave0;
	}

	public void setClave0(String clave0) {
		this.clave0 = clave0;
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public String getClave3() {
		return clave3;
	}

	public void setClave3(String clave3) {
		this.clave3 = clave3;
	}

	public String getClave4() {
		return clave4;
	}

	public void setClave4(String clave4) {
		this.clave4 = clave4;
	}

	public String getClave5() {
		return clave5;
	}

	public void setClave5(String clave5) {
		this.clave5 = clave5;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
