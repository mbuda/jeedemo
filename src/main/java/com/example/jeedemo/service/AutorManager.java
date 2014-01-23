package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Autor;

@Stateless
public class AutorManager {

	@PersistenceContext
	EntityManager em;
	
	public void addAutor(Autor autor){
		autor.setId(null);
		em.persist(autor);
	}
	
	public List<Autor> getAllAutorzy(){
		return em.createNamedQuery("autor.getAutorzy").getResultList();
	}
	
	public void deleteAutor(Autor autor){
		autor = em.find(Autor.class, autor.getId());
		autor.setDeleted(true);
		//em.remove(autor);
	}
	
	public void edytujAutor(Autor autor){
		em.merge(autor);
	}
}
