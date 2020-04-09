package com.tactfactory.monprojetsb.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tactfactory.monprojetsb.monprojetsb.repositories.ProductRepository;

@Controller
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	public ProductController(ProductRepository repository) {
		this.repository = repository;
	}

	// Liste l'ensemble des attributs de l�entit� pour tout les enregistrements
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("page", "Product index");
		model.addAttribute("items", repository.findAll());
		return "product/index";
	}

	// Affiche la vue de cr�ation d'un �l�ment
	@GetMapping(value = {"/create"})
	public String createGet(Model model) {
		model.addAttribute("page", "Product create");
		return "product/create";
	}

    // Envoie les informations de l'�l�ment vers le serveur et le sauvegarde dans la base de donn�es
	@PostMapping
    public void createPost() {
		// TODO
    }

    // Supprime un �l�ment de la base de donn�es
    public void delete() {
    	// TODO
    }

    // Affiche les d�tails d�un �l�ment
    public void details() {
    	// TODO
    }
}
