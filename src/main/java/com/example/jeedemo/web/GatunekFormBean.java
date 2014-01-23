package com.example.jeedemo.web;import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.example.jeedemo.domain.Gatunek;
import com.example.jeedemo.service.GatunekManager;

@SessionScoped
@Named("gatunekBean")
public class GatunekFormBean implements Serializable{

	private Gatunek gatunek = new Gatunek();
	private ListDataModel<Gatunek> gatunki = new ListDataModel<Gatunek>();
	private Long gatunekId;
	
	@Inject
	GatunekManager gm;
	
	// Actions
	public String addGatunek() {
		gm.addGatunek(gatunek);
		//return "showMangi";
		return null;
	}
	
	public Gatunek getGatunek(){
		return gatunek;
	}
	
	public void setGatunek(Gatunek gatunek){
		this.gatunek = gatunek;
	}
	
	public ListDataModel<Gatunek> getAllGatunki(){
		gatunki.setWrappedData(gm.getAllGatunki());
		return gatunki;
	}

	public Long getGatunekId() {
		return gatunekId;
	}

	public void setGatunekId(Long gatunekId) {
		this.gatunekId = gatunekId;
	}
	
	public String deleteGatunek(Gatunek gatunek){
		gm.deleteGatunek(gatunek);
		return null;
	}
	
	public String doEdycji(Gatunek gatunek){
		this.gatunek = gatunek;
		return "edytujGatunek";
	}
	
	public String edytujGatunek(){
		gm.edytujGatunek(gatunek);
		this.gatunek = new Gatunek();
		return null;
	}

	//Validator - unikalna nazwa gatunku

	public void uniqueNazwa(FacesContext context, UIComponent component, Object value) {
		String nazwa = (String) value;

		for(Gatunek g:gm.getAllGatunki()) {
			if(g.getNazwa().equalsIgnoreCase(nazwa)) {
				FacesMessage message = new FacesMessage("Ta nazwa już istnieje, gatunki są unikalne.");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);	
			}
		}
	}

} 
