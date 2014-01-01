package com.platacad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.services.TrabajoServiceInterface;

@Controller
public class TrabajoController {
	
	@Autowired
    UserInfo userInfo;
	
	@Autowired
	TrabajoServiceInterface trabajoService;

	@RequestMapping("registrar-trabajo.html")
    public ModelAndView grabarAporte(@ModelAttribute("trabajo") TrabajoEncargado trabajoEncargado){
		trabajoService.registrarTrabajo(trabajoEncargado);
    	ModelAndView model = new ModelAndView("listaTrabajos");
    	return model;
    }
	
}
