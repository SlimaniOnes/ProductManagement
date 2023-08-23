package com.example.productManagement.Services;

import java.util.List;

import com.example.productManagement.Entities.*;

public interface ProductService {
	
	Product saveProduct(Product p);
	Product updateProduct(Product p);
	void deleteProduct(Product p);
	 void deleteProductById(Long id);
	 Product getProduct(Long id);
	List<Product> getAllProducts();
	List<Product> findByNomProduct(String nom);
	List<Product> findByNomProductContains(String nom);
	List<Product> findByNomPrix (String nom, Double prix);
	List<Product> findByCategorie (Categorie categorie);
	List<Product> findByCategorieCatNom(String nomCat);
	List<Product> findByOrderByNomProductAsc();
	List<Product> trierProductsNomsPrix();

}
