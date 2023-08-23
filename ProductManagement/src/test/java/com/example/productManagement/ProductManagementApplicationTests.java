package com.example.productManagement;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.productManagement.Entities.Categorie;
import com.example.productManagement.Entities.Product;
import com.example.productManagement.Repositories.CategorieRepository;
import com.example.productManagement.Repositories.ProductRepository;


@SpringBootTest
class ProductManagementApplicationTests {

	
		@Autowired
		private ProductRepository productRepository;
		
		@Autowired
		private CategorieRepository CategorieRepository;
		
		/*@Test
			public void testCreateCategorie() {
			Categorie ct = new ("PC","ones",1);
			CategorieRepository.save(ct);
			}
		
		
		@Test
		public void testCreateProduct() {
		Product prod = new (new Date(),"cappucin",251,"1");
		productRepository.save(prod);
		}
		*/
		@Test
		public void testFindProduit()
		{
			Product p = productRepository.findById(1L).get();
		System.out.println(p);
		}
		@Test
		public void testUpdateProduit()
		{
			Product p = productRepository.findById(1L).get();
		p.setPrixProduct(1000.0);
		productRepository.save(p);
		}
		
		@Test
		public void testDeleteProduit()
		{
			productRepository.deleteById(1L);;
		}

		@Test
		public void testListerTousProduits()
		{
		List<Product> prods = productRepository.findAll();
		for (Product p : prods)
		{
		System.out.println(p);
		}
		}
		
		 @Test
		 public void testFindByNomProduit()
		 {
		 List<Product> prods = productRepository.findByNomProduct("iphone X");
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 @Test
		 public void testFindByNomProduitContains ()
		 {
		 List<Product> prods=productRepository.findByNomProductContains("iphone X");
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 } }
		 
		 
		 @Test
		 public void testfindByNomPrix()
		 {
		 List<Product> prods = productRepository.findByNomPrix("iphone X", 1000.0);
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 @Test
			public void testfindByCategorie()
			{
			Categorie cat = new Categorie();
			cat.setIdCat(1L);
			List<Product> prods = productRepository.findByCategorie(cat);
			for (Product p : prods)
			{
			System.out.println(p);
			}
			}

		 @Test
		 public void findByCategorieCatNom()
		 {
		 List<Product> prods = productRepository.findByCategorieNomCat("");
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 }
		  }

		 @Test
		 public void testfindByOrderByNomProductAsc()
		 {
		 List<Product> prods = productRepository.findByOrderByNomProductAsc();
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 }
		 }
		 
		 @Test
		 public void testTrierProductsNomsPrix()
		 {
		 List<Product> prods = productRepository.trierProductsNomsPrix();
		 for (Product p : prods)
		 {
		 System.out.println(p);
		 }
		 }

		 
		}


