/**
 * 
 */
package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Compte;

/**
 * @author ETY
 *
 */
@Repository("comptedao")
public class CompteDaoImpl implements ICompteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * 
	 * Constructeur
	 * 
	 */
	/**
	 * 
	 */
	public CompteDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * 
	 * 
	 * Méthodes
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#addCompte(com.bankonet.model.Compte)
	 */
	@Transactional(propagation=Propagation.MANDATORY)
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		em.persist(c);
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#deleteCompte(int)
	 */
	@Override
	public void deleteCompte(int idCompte) {
		// TODO Auto-generated method stub
		Compte c=em.find(Compte.class, idCompte);
		em.remove(c);

	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#crediterCompte(float)
	 */
	@Override
	public void crediterCompte(float solde) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#debiterCompte(float)
	 */
	@Override
	public void debiterCompte(float solde) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.bankonet.dao.ICompteDao#listeCompte()
	 */
	@Override
	public List<Compte> listeCompte() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select c from Compte c order by c.id");
		System.out.println("liste compte : " + req.getResultList());
		return req.getResultList();
	}


	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}


	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	

}
