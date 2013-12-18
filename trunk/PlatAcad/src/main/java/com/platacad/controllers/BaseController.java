/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.controllers;

import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Examen;
import com.platacad.model.entities.Matricula;
import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.services.GeneralService;

import java.util.ArrayList;
import java.util.List;

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
    GeneralService generalService;
    
    @Autowired
    UserInfo userInfo;
    
    static List<CursoAperturado> cursos;
   
    @RequestMapping("inicio.html")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        
        List<Matricula> cursosMatriculados = generalService.getCursosMatriculados(1, userInfo.getUser().getIdUsuarioPk());        
        cursos = new ArrayList<CursoAperturado>();
        for(Matricula matricula : cursosMatriculados){
        	cursos.add(matricula.getIdCursoAperturadoFk());
        }

        model.addObject("user", userInfo.getUser());
        model.addObject("cursos", cursos);
        return model;
    }
    
    @RequestMapping("inicio-docente.html")
    public ModelAndView homeDocente(){
        ModelAndView model = new ModelAndView("homeDocente");
        model.addObject("user",  userInfo.getUser().getIdUsuarioPk());
        //model.addObject("cursos_asignados", generalService.getCursosAsignados("45653716"));
        return model;
    }
    
    @RequestMapping("examen.html")
    public ModelAndView articulo(){
        ModelAndView model = new ModelAndView("examen");
        model.addObject("user", userInfo.getUser().getIdUsuarioPk());
        model.addObject("examen", new Examen());
        //model.addObject("tipos_examen",generalService.getTipos("EXAMEN"));
        return model;
    }
    
    @RequestMapping("trabajo.html")
    public ModelAndView trabajoEncargado(){
        ModelAndView model = new ModelAndView("trabajoEncargado");
        model.addObject("user",  userInfo.getUser().getIdUsuarioPk());
        model.addObject("trabajo", new TrabajoEncargado());
        return model;
    }
}
