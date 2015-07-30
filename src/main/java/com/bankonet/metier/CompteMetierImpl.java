/**
 * 
 */
package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bankonet.dao.ICompteDao;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;

/**
 * @author ETY
 *
 */
@Service("comptemetier")
public class CompteMetierImpl implements ICompteMetier {
	
	@Resource(name="comptedao")
	public ICompteDao comptedao;
	
	/*
	 * 
	 * Constructeur par défaut
	 * 
	 */
	/**
	 * 
	 */
	public CompteMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	
		
	/*
	 * 
	 * Méthodes
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#virement(float, int)
	 */
	@Override
	public void virement(float solde, int idCompte) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#addCompte(com.bankonet.model.Compte)
	 */
	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		comptedao.addCompte(c);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#deleteCompte(int)
	 */
	@Override
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		comptedao.deleteCompte(idCompte);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.metier.ICompteMetier#listeCompte()
	 */
	@Override
	public List<Compte> listeCompte() {
		// TODO Auto-generated method stub
		return comptedao.listeCompte();
	}
		
	@Override
	public List<Compte> listCompteclient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Compte editCompte(int idClompte) {
		// TODO Auto-generated method stub
		return comptedao.editCompte(idClompte);
	}



	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		comptedao.updateCompte(c);
		
	}
	
	/*
	 * 
	 * Getters et setter
	 * 
	 */
	
	/**
	 * @return the comptedao
	 */
	public ICompteDao getComptedao() {
		return comptedao;
	}



	/**
	 * @param comptedao the comptedao to set
	 */
	public void setComptedao(ICompteDao comptedao) {
		this.comptedao = comptedao;
	}

	
}
