package com.tactfactory.monprojetsb.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.repositories.ProductRepository;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	public ProductController(ProductRepository repository) {
		this.repository = repository;
	}

	// Liste l'ensemble des attributs d'un produit pour tous les enregistrements
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("page", "Product Index");
		model.addAttribute("items", repository.findAll());
		return "product/index";
	}

	// Affiche la vue de création d'un produit
	@GetMapping(value = {"/create"})
	public String createGet(Model model) {
		model.addAttribute("page", "Product Create");
		return "product/create";
	}

    // Envoie les informations du produit vers le serveur
	@PostMapping(value = {"/create"})
    public String createPost(@ModelAttribute Product product) {
		if (product != null)
			repository.save(product);

		return "redirect:index";
    }

    // Supprime un produit de la base de données
	@PostMapping(value = {"/delete"})
    public String delete(@ModelAttribute Product product) {
		if (product != null)
			repository.delete(product);

		return "redirect:index";
    }

    // Affiche les détails d’un produit
	@GetMapping(value = {"/show/{id}"})
    public String details(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("product", repository.getOne(Long.parseLong(id)));
        return "product/detail";
    }
}
