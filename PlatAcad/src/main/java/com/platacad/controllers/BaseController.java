/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.controllers;

import com.platacad.services.GeneralService;
import com.platacad.services.UsuarioService;
import com.platacad.to.MensajeTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author allen
 */
@Controller
public class BaseController {
    
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    GeneralService generalService;
    
    @RequestMapping("inicio.html")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        model.addObject("user", usuarioService.getUsuario("0512013001"));
        model.addObject("cursos", generalService.getCursos("0512013001"));
        return model;
    }
    
    @RequestMapping("mensajes.html")
    public ModelAndView mensaje(){
        ModelAndView model = new ModelAndView("mensaje");
        model.addObject("user", usuarioService.getUsuario("0512013001"));
        model.addObject("mensaje", new MensajeTO());
        return model;
    }
    
    @RequestMapping("enviarMensaje.html")
    public View enviarMensaje(@ModelAttribute("mensaje") MensajeTO mensaje){    	
    	return new RedirectView("mensajes.html");
    }
}
