package com.platacad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platacad.helpers.Util;
import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.Evento;
import com.platacad.services.EventoServiceInterface;

@Controller
public class EventoController {
	
	@Autowired
    UserInfo userInfo;

	@Autowired
	EventoServiceInterface eventoService;
	
	@RequestMapping("evento.html")
	public ModelAndView nuevoEvento(){
		ModelAndView model = Util.buildModel("evento");
		model.addObject("user",  userInfo.getUser());
		model.addObject("evento",  new Evento());
		return model;		
	}
}
