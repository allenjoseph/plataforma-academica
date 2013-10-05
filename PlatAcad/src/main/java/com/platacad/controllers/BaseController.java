/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.controllers;

import com.platacad.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author allen
 */
@Controller
public class BaseController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @RequestMapping("inicio.html")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        model.addObject("user", usuarioService.getUsuario("0512013001"));
        return model;
    }
}
