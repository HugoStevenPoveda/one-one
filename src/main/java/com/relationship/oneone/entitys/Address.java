package com.relationship.oneone.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 500)
	private String description;
	@Column(name = "estado", nullable = false)
	private Boolean estadoEnvio;

	@JsonBackReference

	@OneToOne(mappedBy = "address")
	private User user;

	// COSTRUCTORES
	public Address() {

	}
//
//	public Address(Long id, String description, Boolean estadoEnvio, User user) {
//		this.id = id;
//		this.description = description;
//		this.estadoEnvio = estadoEnvio;
//		this.user = user;
//	}

	// METODOS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(Boolean estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	@Override
//	public String toString() {
//		return "Address [id =" + id + ", description=" + description + ", estadoEnvio=" + estadoEnvio + "]";
//	}

}
