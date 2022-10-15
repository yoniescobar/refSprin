package com.gestion.fiscalia.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fiscalia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String nombre;
	private String municipio;
	private String direccion;
	private String telefono;

	// Generando un contructor con todos los datos

	public Fiscalia(Integer id, String nombre, String municipio, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	// sin Id en caso necesitamos

	public Fiscalia(String nombre, String municipio, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.municipio = municipio;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	// vacio
	public Fiscalia() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
