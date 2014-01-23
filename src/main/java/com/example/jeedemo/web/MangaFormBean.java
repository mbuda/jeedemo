package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.example.jeedemo.domain.Manga;
import com.example.jeedemo.domain.Autor;
import com.example.jeedemo.domain.Gatunek;
import com.example.jeedemo.service.MangaManager;
import com.example.jeedemo.service.AutorManager;
import com.example.jeedemo.service.GatunekManager;

@SessionScoped
@Named("mangaBean")
public class MangaFormBean implements Serializable {
	
	private Manga manga = new Manga();
	private ListDataModel<Manga> mangi = new ListDataModel<Manga>();
	private DualListModel<Gatunek> tempList; 
	private List<Gatunek> gatunkiTemp ;
	
	private Long mangaId;
	private Long autorId;
	private Long gatunekId;
	
	@Inject
	MangaManager mm;
	@Inject
	AutorManager am;
	@Inject
	GatunekManager gm;	

	
	public Manga getManga() {
		return manga;
	}
	
	public void setManga(Manga manga) {
		this.manga = manga;
	}

	// Actions
	public String addManga() {
		
		mm.addManga(manga);
		mm.addAutorToManga(manga.getId(), autorId);		
		mm.addGatunekToMangaList(manga.getId(), gatunkiTemp);

		return null;
	}
	
	public String deleteManga(Manga manga){
		mm.deleteManga(manga);
		return null;
	}

	public ListDataModel<Manga> getAllMangi() {
		mangi.setWrappedData(mm.getAllMangi());
		return mangi;
	}

	public Long getMangaId() {
		return mangaId;
	}

	public void setMangaId(Long mangaId) {
		this.mangaId = mangaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}
	
	public List<Autor> getAllAutorzy(){
		return am.getAllAutorzy();
	}

	public List<Gatunek> getAllGatunki(){
		return gm.getAllGatunki();
	}
	
	public Long getGatunekId() {
		return gatunekId;
	}

	public void setGatunekId(Long gatunekId) {
		this.gatunekId = gatunekId;
	}

	public DualListModel<Gatunek> getTempList() {
		return (new DualListModel<Gatunek>(gm.getAllGatunki(), new ArrayList<Gatunek>()));
	}

	public void setTempList(DualListModel<Gatunek> tempList) {
		this.tempList = tempList;
	}

    public List<Gatunek> getSelected() {
        return tempList.getTarget();
    }

	public List<Gatunek> getGatunkiTemp() {
		return gatunkiTemp;
	}

	public void setGatunkiTemp(List<Gatunek> gatunkiTemp) {
		this.gatunkiTemp = gatunkiTemp;
	}

	
	public String doEdycji(Manga manga){
		this.manga = manga;
		return "edytujMangi";
	}
	
	public String edytujManga(){
		mm.edytujManga(manga);
		this.manga = new Manga();
		return null;
	}
	
}
