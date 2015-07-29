package com.bankonet.model;

/**
 * Classe utilisee pour lancer les exceptions liees à la partie "metier"
 * de l'application Bankonet.
 * 
 * @author Neobject (c) 
 */
public class BankonetException extends Exception {

	public BankonetException()
	{
		super();
	}
	
	public BankonetException(String _message) {
		super(_message);
	}
	
}
