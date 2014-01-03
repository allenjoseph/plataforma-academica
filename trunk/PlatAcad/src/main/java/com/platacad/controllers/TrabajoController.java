package com.platacad.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.platacad.helpers.SystemMessage;
import com.platacad.helpers.Util;
import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.services.TrabajoServiceInterface;

@Controller
public class TrabajoController {
	
	@Autowired
    UserInfo userInfo;
	
	@Autowired
	TrabajoServiceInterface trabajoService;
	
    @RequestMapping("trabajo.html")
    public ModelAndView trabajoEncargado(){
        ModelAndView model = new ModelAndView("trabajoEncargado");
        model.addObject("user",  userInfo.getUser());
        model.addObject("cursos", userInfo.getCursos());
        model.addObject("trabajo", new TrabajoEncargado());
        return model;
    }
	
	@RequestMapping("registrar-trabajo.html")
	public View registrarTrabajo(@ModelAttribute("trabajo") TrabajoEncargado trabajoEncargado){
		try{
			TrabajoEncargado trabajo = trabajoService.registrarTrabajo(trabajoEncargado);
			Util.mensaje = "Se registro Trabajo Encargado N° "+trabajo.getIdTrabajoPk()+" satisfactoriamente.";	
		}catch(Exception ex){
			Util.error = SystemMessage.PROCESS_ERROR;
		}		
		return new RedirectView("trabajos.html");
	}

	@RequestMapping("trabajos.html")
    public ModelAndView grabarAporte(){		
    	ModelAndView model = Util.buildModel("listaTrabajos"); 
    	model.addObject("user",userInfo.getUser());
    	model.addObject("trabajos", trabajoService.obtenerTrabajos());
    	model.addObject("curso", new CursoAperturado());
    	model.addObject("cursos", userInfo.getCursos());
    	return model;
    }
	
	
}
