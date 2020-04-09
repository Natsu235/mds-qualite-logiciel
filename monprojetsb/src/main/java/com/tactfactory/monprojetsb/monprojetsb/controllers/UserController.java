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

	// Liste l'ensemble des attributs de l�entit� pour tout les enregistrements
	public void index() {
		// TODO
	}

	// Affiche la vue de cr�ation d'un �l�ment
	@GetMapping
    public void createGet() {
		// TODO
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
