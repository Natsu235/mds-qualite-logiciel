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

import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repositories.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repositories.UserRepository;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	private ProductRepository productRepository;

	public UserController(UserRepository userRepository, ProductRepository productRepository) {
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	// Liste l'ensemble des attributs d'un utilisateur pour tous les enregistrements
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("page", "User Index");
		model.addAttribute("items", userRepository.findAll());
		return "user/index";
	}

	// Affiche la vue de création d'un utilisateur
	@GetMapping(value = {"/create"})
    public String createGet(Model model) {
		model.addAttribute("page", "User Create");
		model.addAttribute("products", productRepository.findAll());
        return "user/create";
	}

	// Envoie les informations de l'utilisateur vers le serveur
	@PostMapping(value = {"/create"})
    public String createPost(@ModelAttribute User user) {
		if (user != null)
            userRepository.save(user);

        return "redirect:index";
    }

    // Supprime un utilisateur de la base de données
	@PostMapping(value = {"/delete"})
    public String delete(@ModelAttribute User user) {
		if (user != null)
			userRepository.delete(user);

		return "redirect:index";
    }

    // Affiche les détails d’un utilisateur
	@GetMapping(value = {"/show/{id}"})
    public String details() {
        // TODO
        return "redirect:index";
    }
}
