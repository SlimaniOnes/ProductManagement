package com.example.productManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.productManagement.Entities.Categorie;
import com.example.productManagement.Entities.Product;
@RepositoryRestResource(path = "rest")
public interface ProductRepository extends JpaRepository < Product, Long> {
	List<Product> findByNomProduct(String nom);
	 List<Product> findByNomProductContains(String nom);
	 @Query("select p from Product p where p.nomProduct like %:nom and p.prixProduct > :prix")
	 List<Product> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from Product p where p.categorie = ?1")
	 List<Product> findByCategorie (Categorie categorie);
	 List<Product> findByCategorieNomCat(String nomCat);
	 List<Product> findByOrderByNomProductAsc();
	 @Query("select p from Product p order by p.nomProduct ASC, p.prixProduct DESC")
	 List<Product> trierProductsNomsPrix ();

}