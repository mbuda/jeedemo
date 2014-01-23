package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Gatunek;

@Stateless
public class GatunekManager {

	@PersistenceContext
	EntityManager em;
	
	public void addGatunek(Gatunek gatunek){
		gatunek.setId(null);
		em.persist(gatunek);
	}
	
	public List<Gatunek> getAllGatunki(){
		return em.createNamedQuery("gatunek.getAll").getResultList();
	}
	
	public Gatunek getGatunekId(Long gatunekId){
		return em.find(Gatunek.class, gatunekId);
	}
	
	public void deleteGatunek(Gatunek gatunek){
		gatunek = em.find(Gatunek.class, gatunek.getId());
		gatunek.setDeleted(true);
		//em.remove(gatunek);	
	}
	
	public void edytujGatunek(Gatunek gatunek){
		em.merge(gatunek);
	}
}
