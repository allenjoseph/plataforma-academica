package com.platacad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.platacad.helpers.Util;
import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.Mensaje;
import com.platacad.model.entities.Usuario;
import com.platacad.services.MensajeService;
import com.platacad.services.MensajeServiceInterface;
import com.platacad.services.UsuarioService;
import com.platacad.services.UsuarioServiceInterface;
import com.platacad.to.MensajeTO;
import com.platacad.to.UsuarioTO;

@Controller
public class MensajeController {

	@Autowired
    UsuarioServiceInterface usuarioService;
	
    @Autowired
    MensajeServiceInterface mensajeService;
    
    @Autowired
    UserInfo userInfo;
	
	@RequestMapping("mensaje.html")
    public ModelAndView mensaje(){
        ModelAndView model = Util.buildModel("mensaje");
        model.addObject("user", userInfo.getUser());
        model.addObject("mensaje", new Mensaje(userInfo.getUser()));
        return model;
    }
	
	@RequestMapping("mensajes.html")
    public ModelAndView listaMensajes(){
        ModelAndView model = Util.buildModel("listaMensajes");
        model.addObject("user", userInfo.getUser());
        model.addObject("mensajes", mensajeService.obtenerMensajes(userInfo.getUser()));
        return model;
    }
	
	
	
	
	
	
	
	
	 
    @RequestMapping("enviarMensaje.html")
    public View enviarMensaje(@ModelAttribute("mensaje") Mensaje mensaje){
        mensajeService.enviarMensaje(mensaje);    	
        return new RedirectView("listarMensaje.html");        
    }
    
    @RequestMapping("listarMensaje.html")
    public ModelAndView listarMensaje(){
        ModelAndView model = new ModelAndView("listarmensaje");
        model.addObject("listado", mensajeService.listarMensaje("0512013001"));
        return model;
    }
    
    @RequestMapping(value = "eliminar-mensaje.html", method = RequestMethod.GET)
    public ModelAndView EliminarMensaje( @RequestParam("codigo") int codigo ){
        System.out.println("codigo"+codigo);
        mensajeService.eliminarMensaje(codigo);
        ModelAndView model = new ModelAndView("listarmensaje");
        model.addObject("listado", mensajeService.listarMensaje("0512013001"));
        return model;
    }
    
    /*EJEMPLO JSON - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
   	@RequestMapping(value = "listar-mensajes.json", method = RequestMethod.GET)
   	public @ResponseBody  List<MensajeTO> obtenerListaMensajes() {
		List<MensajeTO> lista = mensajeService.listarMensaje("0512013001");        
		return lista;
	}
}
