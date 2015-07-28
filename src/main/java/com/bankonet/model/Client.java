/**
 * 
 */
package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ETY
 *
 */
@Entity
@DiscriminatorValue("C")
public class Client extends Personne {

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	

	/**
	 * 
	 */
	@NotNull
	@Size(min=2, max=16)
	String login;
	@NotNull
	@Size(min=5, max=50)
	String motDePasse;

	@Autowired
	private Adresse adresse;

	/*
	 * 
	 * Génération des constructeurs
	 * 
	 */

	/**
	 * 
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ids
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom,String login, String motDePasse, Adresse adresse) {
		super(nom, prenom);
		this.login=login;
		this.motDePasse=motDePasse;
		this.adresse=adresse;
		// TODO Auto-generated constructor stub
	}
	
	public Client(int id){
		super(id);
	}
	
	/**
	 * @param adresse
	 */
	public Client(Adresse adresse) {
		super();
		this.adresse = adresse;
	}

	/*
	 * Méthodes
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id : "+this.getId() + " ; " +" nom : "+this.getNom()+" ; "+ " Prenom : "+ this.getPrenom()+" ; "+" adresse : "+this.getAdresse()+" ; "+" a comme login :" + this.getLogin() ;
	}

	/*
	 * 
	 * Génération des getters/setters
	 * 
	 */
	
	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
