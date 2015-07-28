/**
 * 
 */
package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

/**
 * @author ETY
 *
 */
@Controller
public class BankonetController {

	@Autowired
	private IBankonetMetier bankonetmetier;
		
	
	/**
	 * 
	 */
	public BankonetController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("clients", bankonetmetier.listClients());
		model.addAttribute("client",new Client());
		
		return "clientsview";
		
	}
	
	/**
	 * 
	 * @param c
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client c, BindingResult bindingResult, Model  model) {
		
	
			
		if(bindingResult.hasErrors()) {
			model.addAttribute("clients",  bankonetmetier.listClients());
			return  "clientsview"; 
		}
		return null;

	
	}
}
