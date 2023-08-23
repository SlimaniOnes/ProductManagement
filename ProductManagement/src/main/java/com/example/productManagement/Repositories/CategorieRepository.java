package com.example.productManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productManagement.Entities.Categorie;

public interface CategorieRepository extends JpaRepository < Categorie, Long>  {
	Categorie getCategorieByNomCat (String nom);

}
