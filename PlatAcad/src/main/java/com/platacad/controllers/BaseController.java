/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.controllers;

import com.platacad.helpers.Util;
import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.Usuario;
import com.platacad.services.GeneralServiceInterface;
import com.platacad.services.UsuarioServiceInterface;
import com.platacad.to.UsuarioTO;
import com.platacad.to.TimelineItemTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author allen
 */
@Controller
public class BaseController {
    
    @Autowired
    GeneralServiceInterface generalService;
    
    @Autowired
    UsuarioServiceInterface usuarioService;
    
    @Autowired
    UserInfo userInfo;

    @RequestMapping("inicio.html")
    public ModelAndView home(){
    	String inicio = "logon";
    	if(userInfo.getUser().getIsAlumno()){
    		inicio = "home";
    	}else if(userInfo.getUser().getIsDocente()){
    		inicio = "homeDocente";
    	}else if(userInfo.getUser().getIsAdministrativo()){
    		inicio = "homeAdministrativo";
    	}
    	
    	ModelAndView model = new ModelAndView(inicio);
        model.addObject("user", userInfo.getUser());
        model.addObject("cursos", userInfo.getCursos());
        return model;
    }
    
    @RequestMapping(value = "get-usuarios.json", method = RequestMethod.GET)
   	public @ResponseBody  List<UsuarioTO> getUsuarios() {
		List<UsuarioTO> lista = usuarioService.getUsuarios("a");        
		return lista;
	}
    
    @RequestMapping(value = "get-timelime.json", method = RequestMethod.GET)
   	public @ResponseBody  List<TimelineItemTO> getTimeLine() {
    	Usuario user = userInfo.getUser();
    	user.setCursoAperturadoList(userInfo.getCursos());
		List<TimelineItemTO> lista = generalService.getTimeline(user);        
		return lista;
	}
    
    @RequestMapping("eventos.html")
    public ModelAndView listarEventos(){
    	ModelAndView model = Util.buildModel("listaEventos");
    	model.addObject("user", userInfo.getUser());
    	return model;
    }
}
