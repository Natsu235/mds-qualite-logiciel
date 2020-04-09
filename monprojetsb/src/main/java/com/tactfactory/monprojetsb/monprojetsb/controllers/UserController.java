package com.tactfactory.monprojetsb.monprojetsb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.monprojetsb.monprojetsb.repositories.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired UserRepository repository;

	// Liste l'ensemble des attributs de l’entité pour tout les enregistrements
	public void index() {
		// TODO
	}

	// Affiche la vue de création d'un élément
	@GetMapping
    public void createGet() {
		// TODO
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
