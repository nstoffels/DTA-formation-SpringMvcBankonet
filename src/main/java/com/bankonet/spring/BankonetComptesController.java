/**
 * 
 */
package com.bankonet.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.metier.ICompteMetier;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;

/**
 * @author ETY
 *
 */
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
	@RequestMapping(value="/comptescourants/{id}", method = RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("client",new Client());
		model.addAttribute("compte", new CompteCourant());
		
		model.addAttribute("clients", bankonetmetier.listClients());
		
		model.addAttribute("info", "vide");
		
		return "/comptescourants/{id}";
		
	}
	

}
