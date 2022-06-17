package com.doranco.flash.produit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.doranco.flash.produit.entities.Produit;

@Component
public class Dbinit implements CommandLineRunner 
{
	private ProduitRepository produitRepository;
	
	

	public Dbinit(ProduitRepository produitRepository) {
		
		this.produitRepository = produitRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Produit> produits = new ArrayList<>();
		
		produits.add(new Produit(0, "Macbook- Pro", 689.89, 19));
		produits.add(new Produit(1, "Iphone", 29.89, 10));
		produits.add(new Produit(2, "Samsung- Pro", 1750, 12));
		produits.add(new Produit(3, "Windows touch", 58.89, 7));
		
		
		produitRepository.saveAll(produits);
		
		
		
		
	}
}
