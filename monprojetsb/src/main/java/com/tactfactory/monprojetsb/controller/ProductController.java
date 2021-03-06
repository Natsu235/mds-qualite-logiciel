package com.tactfactory.monprojetsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tactfactory.monprojetsb.entity.Product;
import com.tactfactory.monprojetsb.repository.ProductRepository;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Liste l'ensemble des attributs d'un produit pour tous les enregistrements
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("page", "Product Index");
        model.addAttribute("items", productRepository.findAll());
        return "product/index";
    }

    // Affiche la vue de cr�ation d'un produit
    @GetMapping(value = {"/create"})
    public String createGet(Model model) {
        model.addAttribute("page", "Product Create");
        return "product/create";
    }

    // Envoie les informations du produit vers le serveur
    @PostMapping(value = {"/create"})
    public String createPost(@ModelAttribute Product product) {
        if (product != null)
            productRepository.save(product);

        return "redirect:index";
    }

    // Supprime un produit de la base de donn�es
    @PostMapping(value = {"/delete"})
    public String delete(@ModelAttribute Product product) {
        if (product != null)
            productRepository.delete(product);

        return "redirect:index";
    }

    // Affiche les d�tails d�un produit
    @GetMapping(value = {"/show/{id}"})
    public String details(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("product", productRepository.getOne(Long.parseLong(id)));
        return "product/details";
    }

}
