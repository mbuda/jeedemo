package com.example.jeedemo.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Autor;
import com.example.jeedemo.domain.Gatunek;
import com.example.jeedemo.service.AutorManager;

@SessionScoped
@Named("autorBean")
public class AutorFormBean implements Serializable{

	private Autor autor = new Autor();
	private ListDataModel<Autor> autorzy = new ListDataModel<Autor>();
	private List<SelectItem> lista = new ArrayList<SelectItem>();
	
	@Inject
	AutorManager am;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String addAutor(){
		am.addAutor(autor);
		return null;
	}
	
	
	public List<Autor> getAllAutorzy(){
		return am.getAllAutorzy();
	}
	
	
	public String deleteAutor(Autor autor){
		am.deleteAutor(autor);
		return null;
	}
	
	public String doEdycji(Autor autor){
		this.autor = autor;
		return "edytujAutora";
	}
	
	public String edytujAutor(){
		am.edytujAutor(autor);
		this.autor = new Autor();
		return null;
	}
	
}
