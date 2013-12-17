package com.platacad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platacad.model.entities.Articulo;
import com.platacad.services.UsuarioService;

@Controller
public class AporteController {
	
	@Autowired
    UsuarioService usuarioService;
	
    @RequestMapping("aporte.html")
    public ModelAndView nuevoAporte(){
    	ModelAndView model = new ModelAndView("aporte");
    	model.addObject("aporte", new Articulo());
    	model.addObject("user", BaseController.usuarioLogeado);
    	model.addObject("cursos", BaseController.cursos);
    	return model;
    }
    
    @RequestMapping("grabar-aporte.html")
    public ModelAndView grabarAporte(@ModelAttribute("aporte") Articulo articulo){
    	ModelAndView model = new ModelAndView("aporte");
    	Integer estado = articulo.getEstado();
    	return model;
    }
}