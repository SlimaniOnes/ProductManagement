package com.example.productManagement.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

	@Entity
	public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	@JsonIgnore
	@OneToMany(mappedBy = "categorie")
	private List<Product> products;
	
	
	
	public Categorie() {
		super();
	}
	public Categorie(Long idCat, String nomCat, String descriptionCat, List<Product> products) {
		super();
		this.idCat = idCat;
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
		this.products = products;
	}
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescriptionCat() {
		return descriptionCat;
	}
	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	}
