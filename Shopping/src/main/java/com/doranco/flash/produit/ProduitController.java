package com.doranco.flash.produit;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doranco.flash.produit.entities.Produit;

@RestController
@RequestMapping(value = "/produits")
public class ProduitController {
	
	ProduitRepository produitRepository;

	public ProduitController(ProduitRepository produitRepository) {
		
		this.produitRepository = produitRepository;
	}
	
	@GetMapping("/all")
	public List<Produit> getAllProduits()
	{
		return produitRepository.findAll();
	}
	
	@GetMapping("/getProduct/{id}")
	public List<Produit> getProduitById(@PathVariable long id)
	{
		produitRepository.findById(id);
		return produitRepository.findAll();
	}
	
	@PostMapping("/add")
	public List<Produit> addProduit(@RequestBody Produit produit)
	{
		produitRepository.save(produit);
		
		return produitRepository.findAll();
		
		}
	
	@PutMapping("/update/{id}")
	public List<Produit> updateProduit(@RequestBody Produit produit, @PathVariable long id)
	{
		produitRepository.findById(id).ifPresent(tempProduit ->{
			tempProduit.setNom(produit.getNom());
			tempProduit.setPrix(produit.getPrix());
			tempProduit.setQuantity(produit.getQuantity());
			
				produitRepository.save(tempProduit);
				
		});
		
		return produitRepository.findAll();
		
	}
	
	@GetMapping("/delete/{id}")
	public List<Produit> deleteProduit(@PathVariable long id)
	{
	
		produitRepository.deleteById(id);
		
		return produitRepository.findAll();
		}
	

}
