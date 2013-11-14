/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.controllers;

import com.platacad.entities.Examen;
import com.platacad.entities.Mensaje;
import com.platacad.entities.TrabajoEncargado;
import com.platacad.entities.Usuario;
import com.platacad.services.GeneralService;
import com.platacad.services.MensajeService;
import com.platacad.services.UsuarioService;
import com.platacad.to.MensajeTO;

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
    @Autowired
    MensajeService mensajeService;
    
    @RequestMapping("inicio.html")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        Usuario u = usuarioService.getUsuario("0512013001");
        model.addObject("user", u);
        model.addObject("cursos_matriculados", generalService.getCursosMatriculados("0512013001"));
        return model;
    }
    
    @RequestMapping("inicio-docente.html")
    public ModelAndView homeDocente(){
        ModelAndView model = new ModelAndView("homeDocente");
        model.addObject("user", usuarioService.getUsuario("45653716"));
        model.addObject("cursos_asignados", generalService.getCursosAsignados("45653716"));
        return model;
    }
    
    @RequestMapping("mensaje.html")
    public ModelAndView mensaje(){
        ModelAndView model = new ModelAndView("mensaje");
        Mensaje m = new Mensaje();
        m.setIdUsuarioFk(usuarioService.buscarUsuario("0512013001"));
        model.addObject("user", usuarioService.getUsuario("0512013001"));
        model.addObject("mensaje", m);
        return model;
    }
    
    @RequestMapping("examen.html")
    public ModelAndView articulo(){
        ModelAndView model = new ModelAndView("examen");
        model.addObject("user", usuarioService.getUsuario("45653716"));
        model.addObject("examen", new Examen());
        model.addObject("tipos_examen",generalService.getTipos("EXAMEN"));
        return model;
    }
    
    @RequestMapping("trabajo.html")
    public ModelAndView trabajoEncargado(){
        ModelAndView model = new ModelAndView("trabajoEncargado");
        model.addObject("user", usuarioService.getUsuario("45653716"));
        model.addObject("trabajo", new TrabajoEncargado());
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