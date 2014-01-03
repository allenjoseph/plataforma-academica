package com.platacad.controllers;

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
import com.platacad.model.entities.Examen;
import com.platacad.model.enums.TipoExamenEnum;
import com.platacad.services.ExamenServiceInterface;

@Controller
public class ExamenController {

	@Autowired
    UserInfo userInfo;
	
	@Autowired
	ExamenServiceInterface examenService;
	
    @RequestMapping("examen.html")
    public ModelAndView articulo(){
        ModelAndView model = new ModelAndView("examen");
        model.addObject("user", userInfo.getUser());
        model.addObject("cursos", userInfo.getCursos());        
        model.addObject("tipos_examen",TipoExamenEnum.list);
        model.addObject("examen", new Examen());
        return model;
    }
	
	@RequestMapping("registrar-examen.html")
	public View registrarTrabajo(@ModelAttribute("examen") Examen examen){
		//try{
			Examen ex = examenService.registrarExamen(examen);
			Util.mensaje = "Se registro Examen N° "+ex.getIdExamen()+" satisfactoriamente.";	
		//}catch(Exception ex){
			Util.error = SystemMessage.PROCESS_ERROR;
		//}
		return new RedirectView("examenes.html");
	}

	@RequestMapping("examenes.html")
    public ModelAndView grabarAporte(){		
    	ModelAndView model = Util.buildModel("listaExamenes"); 
    	model.addObject("user",userInfo.getUser());
    	model.addObject("examenes", examenService.obtenerExamenes());
    	model.addObject("curso", new CursoAperturado());
    	model.addObject("cursos", userInfo.getCursos());
    	return model;
    }
	
	
}
