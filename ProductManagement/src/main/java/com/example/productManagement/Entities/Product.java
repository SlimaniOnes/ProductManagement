package com.example.productManagement.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idProduct;
private String nomProduct;
private Double prixProduct;
private LocalDateTime dateCreation;
@ManyToOne
private Categorie categorie;

public Product() {
	super();
}


public Product(String nomProduct, Double prixProduct, LocalDateTime dateCreation, Categorie categorie) {
	super();
	this.nomProduct = nomProduct;
	this.prixProduct = prixProduct;
	this.dateCreation = dateCreation;
	this.categorie = categorie;
}

public Categorie getCategorie() {
	return categorie;
}


public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}



public LocalDateTime getDateCreation() {
	return dateCreation;
}

public void setDateCreation(LocalDateTime dateCreation) {
	this.dateCreation = dateCreation;
}


public Long getIdProduct() {
	return idProduct;
}


public void setIdProduct(Long idProduct) {
	this.idProduct = idProduct;
}


public String getNomProduct() {
	return nomProduct;
}


public void setNomProduct(String nomProduct) {
	this.nomProduct = nomProduct;
}


public Double getPrixProduct() {
	return prixProduct;
}


public void setPrixProduct(Double prixProduct) {
	this.prixProduct = prixProduct;
}


@Override
public String toString() {
	return "Product [idProduct=" + idProduct + ", nomProduct=" + nomProduct + ", prixProduct=" + prixProduct
			+ ", dateCreation=" + dateCreation + ", categorie=" + categorie + "]";
}






}