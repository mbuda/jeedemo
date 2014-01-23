package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="manga.getAllMangi" , query = "Select m FROM Manga m ")
public class Manga {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tytul;
	private int tomy;
	@ManyToOne
	private Autor autor;
	@ManyToMany
	private List<Gatunek> gatunki = new ArrayList<Gatunek>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public int getTomy() {
		return tomy;
	}
	public void setTomy(int tomy) {
		this.tomy = tomy;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Gatunek> getGatunki(){
		return gatunki;
	}
	public void setGatunki(List<Gatunek> gatunki) {
		this.gatunki = gatunki;
	}
	
}
