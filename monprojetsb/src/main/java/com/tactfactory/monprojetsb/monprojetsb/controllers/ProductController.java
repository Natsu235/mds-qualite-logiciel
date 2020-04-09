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

	// Liste l'ensemble des attributs de l’entité pour tout les enregistrements
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("page", "Product index");
		model.addAttribute("items", repository.findAll());
		return "product/index";
	}

	// Affiche la vue de création d'un élément
	@GetMapping(value = {"/create"})
	public String createGet(Model model) {
		model.addAttribute("page", "Product create");
		return "product/create";
	}

    // Envoie les informations de l'élément vers le serveur et le sauvegarde dans la base de données
	@PostMapping
    public void createPost() {
		// TODO
    }

    // Supprime un élément de la base de données
    public void delete() {
    	// TODO
    }

    // Affiche les détails d’un élément
    public void details() {
    	// TODO
    }
}
