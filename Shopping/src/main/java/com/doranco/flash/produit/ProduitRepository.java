package com.doranco.flash.produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.flash.produit.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>
{
	List<Produit> findProductById(int id);

}
