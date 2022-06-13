package com.progra3.petstore.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mascotas")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Rellene este campo")
	private String nombre;
	
	@NotNull(message = "Rellene este campo")
	private double precio;
	
	@Column(name = "cumpleanos")
	@NotNull(message="Rellene este campo")
	@Temporal(TemporalType.DATE)
	private Date cumpleanos;

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getCumpleanos() {
		return cumpleanos;
	}

	public void setCumpleanos(Date cumpleanos) {
		this.cumpleanos = cumpleanos;
	}
	

	
	
}