/**
 * 
 */
package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.metier.ICompteMetier;
import com.bankonet.model.CompteCourant;

/**
 * @author ETY
 *
 */
@Controller
@RequestMapping(value="/comptes")
public class BankonetComptesController {

	@Autowired
	private IBankonetMetier bankonetmetier;
	
	@Autowired
	private ICompteMetier comptemetier;
	/*
	 * 
	 * Constructeur
	 * 
	 */
	/**
	 * 
	 */
	public BankonetComptesController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 * Méthodes
	 * 
	 */
	@RequestMapping(value="/comptescourantsliste", method = RequestMethod.GET)
	public String index(Model model, @PathVariable("id") int id){
		

		model.addAttribute("compte", new CompteCourant());
		model.addAttribute("comptes", comptemetier.listeCompte());
		
		model.addAttribute("info", "vide");
		
		return "/comptescourantsliste";
		
	}
	
	@RequestMapping(value="/saveCompte", method = RequestMethod.POST)
	public String saveClient(@Valid CompteCourant c, BindingResult bindingResult, Model  model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("comptes",  comptemetier.listeCompte());
			model.addAttribute("info", "vide");
			model.addAttribute("clients", bankonetmetier.listClients());
			return  "clientsview"; 
		}
		
		System.out.println("************************Tentative d'une possible sauvegarde/modification*******************************");
		System.out.println("***************************"+c.getIdentifiant()+"******************************************");
		try{
			if(c.getIdentifiant()!=0){
				//update et edition du client.
				comptemetier.addCompte(c);
				model.addAttribute("info", "editer");
			}else{
				comptemetier.updateCompte(c);
				System.out.println("Compte sauvegardé");
				model.addAttribute("info", "sauvegarde");
			}
			model.addAttribute("clients", bankonetmetier.listClients());
			
			return  "clientsview";
			
		}catch(Exception e){
			System.out.println("Sauvegarde impossible.");
			e.printStackTrace();
		}
		model.addAttribute("clients", bankonetmetier.listClients());
		return "clientsview";

	
	}

}
