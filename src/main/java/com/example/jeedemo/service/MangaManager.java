package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Manga;
import com.example.jeedemo.domain.Autor;
import com.example.jeedemo.domain.Gatunek;

@Stateless
public class MangaManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addManga(Manga manga) {
		manga.setId(null);
		em.persist(manga);
	}
	
	public void addAutorToManga(Long mangaId, Long autorId){
		Manga manga = em.find(Manga.class, mangaId);
		Autor autor = em.find(Autor.class, autorId);
		manga.setAutor(autor);
	}
	
	public void addGatunekToMangaList(Long mangaId, List<Gatunek> tempList){
		Manga manga = em.find(Manga.class, mangaId);
		for(Gatunek g : tempList)
			manga.getGatunki().add(g);
		//manga.setgatunki(tempList);
	}
	

//	
	public void addGatunekToManga(Long mangaId, List<Long> listaId){
		Manga manga = em.find(Manga.class, mangaId);
		for(Long id : listaId){
			Gatunek gatunek = em.find(Gatunek.class, id);
			manga.getGatunki().add(gatunek);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Manga> getAllMangi(){
		return em.createNamedQuery("manga.getAllMangi").getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void deleteManga(Manga manga){
		manga = em.find(Manga.class, manga.getId());
		em.remove(manga);
	}
	
	public void edytujManga(Manga manga){
		em.merge(manga);
	}
	
}
