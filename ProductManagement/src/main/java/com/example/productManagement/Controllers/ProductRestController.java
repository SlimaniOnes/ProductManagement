package com.example.productManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.productManagement.Entities.Categorie;
import com.example.productManagement.Entities.Product;
import com.example.productManagement.Services.*;

@Controller
@RequestMapping("/products")
@CrossOrigin
public class ProductRestController {

	@Autowired
	ProductService pS;
	
	@Autowired
	CategorieService categorieService;
	
	
	
	 public ProductRestController(ProductService pS, CategorieService categorieService) {
		super();
		this.pS = pS;
		this.categorieService = categorieService;
	}

	@GetMapping("/all")
	    public String getAllProducts(Model model) {
	        model.addAttribute("products", pS.getAllProducts());
	        return "product-list";}
	
	 @GetMapping("details/{id}")
	    public String getProductDetails(@PathVariable("id") Long id, Model model) {
	        Product product = pS.getProduct(id);
	        model.addAttribute("product", product);
	        return "product-details"; 
	    }
	
	
	 @GetMapping("/new")
	    public String showCreateProductForm(Model model) {
	        model.addAttribute("product", new Product());
	        model.addAttribute("categories", categorieService.getAllCategories());
	        return "create-product";
	    }

	    @PostMapping("/all")
	    public String createProduct(@ModelAttribute("product") Product product) {
	        pS.saveProduct(product);
	        return "redirect:/products/all";
	    }
	 
		
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Long id, Model model) {     
	        model.addAttribute("categories", categorieService.getAllCategories());
	        model.addAttribute("product", pS.getProduct(id));
	        	        return "update-product"; 
	    }

	    @PostMapping( "/{id}")
	    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product product) {
	      Product p = pS.getProduct(id);
	      p.setIdProduct(id);
	      p.setNomProduct(product.getNomProduct());
	      p.setPrixProduct(product.getPrixProduct());
	      p.setDateCreation(product.getDateCreation());
	      p.setCategorie(product.getCategorie());
	      
	      
	        pS.updateProduct(p);
	        return "redirect:/products/all"; 
	    }

		
		 @DeleteMapping("/{id}")
	public String  deleteProduct(@PathVariable("id") Long id)
	{
		pS.deleteProductById(id);
		 return "redirect:/products/all";
	}
	
		 @GetMapping("/productsByCategory/{nomCat}")

			public String getProductsBynomCat(@RequestParam("nomCat") String nomCat, Model model) {
			 List<Product> products = pS.findByCategorieCatNom(nomCat);
			    model.addAttribute("products", products);
			    model.addAttribute("selectedCategory", nomCat);
			    return "result";
	}
	
		 
	
	
	 	 @GetMapping("/search")
	    public String findByNomProductContains (@RequestParam("nom") String nom, Model model) {
		 List<Product> searchResults = pS.findByNomProductContains(nom);
	
		    model.addAttribute("searchResults", searchResults);
		    model.addAttribute("selectedname", nom);
		
		    return "search";
	
	 	 }	
	 	 
	 	 
			
		 	 
	 	 
	 	 
	 

	

	 	
	 	}
 	 

