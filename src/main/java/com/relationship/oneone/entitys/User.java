package com.relationship.oneone.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre", nullable = false, length = 450)
	private String nombre;
	@Column(name = "edad", nullable = false, length = 110)
	private int edad;
	@Column(name = "nacionalidad", nullable = false, length = 450)
	private String pais;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	// CONSTRUCTORS

//	public User(Long id, String nombre, int edad, String pais, Address address) {
//		this.id = id;
//		this.nombre = nombre;
//		this.edad = edad;
//		this.pais = pais;
//		this.address = address;
//	}

	public User() {

	}

	// METODOS

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	@Override
//	public String toString() {
//		return "User [id =" + id + ", nombre=" + nombre + ", edad=" + edad + "," + " pais=" + pais + "]";
//	}
}
