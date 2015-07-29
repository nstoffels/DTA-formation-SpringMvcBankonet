/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

/**
 * @author ETY
 *
 */
public interface ICompteDao {
	
	public void addCompte(Compte c);
	public void deleteCompte(int idCompte);
	public void crediterCompte(float solde);
	public void debiterCompte(float solde);
	public List<Compte> listeCompte();
	public List<Compte> listCompteclient(Client c);

}
