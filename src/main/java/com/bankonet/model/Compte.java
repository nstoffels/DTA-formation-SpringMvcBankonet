package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;


/**
 * @author Neobject
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Compte {
	@TableGenerator(name="matable",allocationSize=1)
	@Id @GeneratedValue(strategy=GenerationType.TABLE,generator="matable")
	private int identifiant;
	
	private String libelle;
	protected float solde;

	
	@ManyToOne
	@JoinColumn(name = "clientId")
	private Client client;
	
	
	/**
	 * Constructeur standard.
	 */
	Compte(int id, String libelle, float solde) {

		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;

	}
	Compte() {

	}
	
	
	public abstract boolean creditAutorise(float montant) throws BankonetException;


	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
