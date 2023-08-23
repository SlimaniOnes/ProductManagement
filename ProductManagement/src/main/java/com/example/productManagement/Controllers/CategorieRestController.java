package com.example.productManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.productManagement.Entities.*;
import com.example.productManagement.Services.*;

@Controller
@RequestMapping("/categories")
@CrossOrigin
public class CategorieRestController {

		@Autowired
		CategorieService cS;

	public CategorieRestController(CategorieService cS) {
		super();
		this.cS = cS;
	}



	@GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", cS.getAllCategories());
        return "categorie-list";
        }
	
	
	 @GetMapping("/new")
	    public String showCreateCategorieForm(Model model) {
	        model.addAttribute("categorie", new Categorie());
	        model.addAttribute("categories", cS.getAllCategories());
	        return "create-categorie";
	    }
	 
	
	 @PostMapping("/all")
	    public String createCategorie(@ModelAttribute("categorie") Categorie categorie) {
	        cS.saveCategorie(categorie);
	        return "redirect:/categories/all";
	    }
	 
	 
	 @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Long id, Model model) {     
	        model.addAttribute("categorie", cS.getCategorie(id));
	        	        return "update-categorie"; 
	    }
	 
	 
	 @PostMapping( "/{id}")
	    public String updateCategorie(@PathVariable("id") Long id, @ModelAttribute Categorie categorie) {
	      Categorie c = cS.getCategorie(id);
	      c.setIdCat(id);
	      c.setNomCat(categorie.getNomCat());
	      c.setDescriptionCat(categorie.getDescriptionCat());      
	        cS.updateCategorie(c);
	        return "redirect:/categories/all"; 
	    }

		
		 @DeleteMapping("/{id}")
	public String  deleteProduct(@PathVariable("id") Long id)
	{
		cS.deleteCategorieById(id);
		 return "redirect:/categories/all";
	}
	 
		 @GetMapping("/search/{nom}")
		    public String findByNomProductContains (@RequestParam("nom") String nom, Model model) {
			
		
			    model.addAttribute("searchResults",  cS.getCategorieByNomCat(nom));
			   
			
			    return "search";
		
		 	 }	
	 
	
	
	
	
}
