package com.example.productManagement.Services;

import java.util.List;

import com.example.productManagement.Entities.Categorie;

public interface CategorieService {
	Categorie saveCategorie(Categorie c);
	Categorie updateCategorie(Categorie c);
	void deleteCategoriet(Categorie c);
	 void deleteCategorieById(Long id);
	 Categorie getCategorie(Long id);
	 Categorie getCategorieByNomCat(String nom);
	List<Categorie> getAllCategories();

}
