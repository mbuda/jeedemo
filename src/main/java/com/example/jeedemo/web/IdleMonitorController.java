package com.example.jeedemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class IdleMonitorController {
	
	public void idleListener() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
										"Your session is closed", "You have been idle for at least 5 seconds"));
		
		//invalidate session
	}

    public void activeListener() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Welcome Back", "That's a long coffee break!"));
	}
}

					