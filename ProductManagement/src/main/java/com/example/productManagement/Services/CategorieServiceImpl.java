package com.example.productManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productManagement.Entities.Categorie;
import com.example.productManagement.Repositories.CategorieRepository;
@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired 
	CategorieRepository cR;
	
	@Override
	public Categorie saveCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return cR.save(c);	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return cR.save(c);
	}

	@Override
	public void deleteCategoriet(Categorie c) {
		// TODO Auto-generated method stub
		cR.delete(c);
	}

	@Override
	public void deleteCategorieById(Long id) {
		// TODO Auto-generated method stub
		cR.deleteById(id);
	}

	@Override
	public Categorie getCategorie(Long id) {
		// TODO Auto-generated method stub
		return cR.findById(id).get();
	}

	@Override
	public Categorie getCategorieByNomCat (String nom) {
		// TODO Auto-generated method stub
		return cR.getCategorieByNomCat(nom);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
