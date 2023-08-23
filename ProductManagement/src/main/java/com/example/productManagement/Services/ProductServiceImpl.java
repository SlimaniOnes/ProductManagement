package com.example.productManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productManagement.Entities.Categorie;
import com.example.productManagement.Entities.Product;
import com.example.productManagement.Repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pR;

	@Override
	public Product saveProduct(Product p) {
		return pR.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		return pR.save(p);

	}

	@Override
	public void deleteProduct(Product p) {
		pR.delete(p);
		
	}

	@Override
	public void deleteProductById(Long id) {
		pR.deleteById(id);	
	}

	@Override
	public Product getProduct(Long id) {
		return pR.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		return pR.findAll();
	}

	@Override
	public List<Product> findByNomProduct(String nom) {
		return pR.findByNomProduct(nom);
	}

	@Override
	public List<Product> findByNomProductContains(String nom) {
		return pR.findByNomProductContains(nom);
	}

	@Override
	public List<Product> findByNomPrix(String nom, Double prix) {
		return pR.findByNomPrix(nom, prix);
	}

	@Override
	public List<Product> findByCategorie(Categorie categorie) {
		return pR.findByCategorie(categorie);
	}

	@Override
	public List<Product> findByCategorieCatNom(String nomCat) {
		return pR.findByCategorieNomCat(nomCat);
	}
	

	@Override
	public List<Product> findByOrderByNomProductAsc() {
		return pR.findByOrderByNomProductAsc();
	}
	
	@Override
	public List<Product> trierProductsNomsPrix() {
		return pR.trierProductsNomsPrix();
	}
	

}
