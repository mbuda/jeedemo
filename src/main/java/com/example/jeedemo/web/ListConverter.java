package com.example.jeedemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.example.jeedemo.domain.Gatunek;
import com.example.jeedemo.service.MangaManager;
import com.example.jeedemo.service.GatunekManager;

//@FacesConverter("listaConverter")
@FacesConverter(forClass = Gatunek.class, value="listaConverter")
public class ListConverter implements Converter {
	
	@Inject
	MangaFormBean mfb;
	@Inject 
	GatunekManager gm;
	@Inject
	MangaManager mm;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null){
			return null;
		}
		return mm.getEm().find(Gatunek.class, Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return "";
		}
		if(value instanceof Gatunek){
			return String.valueOf(((Gatunek) value).getId());
		}
		return "";
	}

}
