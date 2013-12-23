package com.platacad.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.Archivo;
import com.platacad.model.entities.Articulo;
import com.platacad.services.UsuarioService;

@Controller
public class AporteController {
	
	@Autowired
    UsuarioService usuarioService;
	
	@Autowired
    UserInfo userInfo;
	
	private Archivo archivoAporte;
	
    @RequestMapping("aporte.html")
    public ModelAndView nuevoAporte(){
    	ModelAndView model = new ModelAndView("aporte");
    	model.addObject("aporte", new Articulo());
    	model.addObject("user", userInfo.getUser());
    	model.addObject("cursos", userInfo.getCursos());
    	archivoAporte = new Archivo();
    	archivoAporte.setIdUsuarioFk(userInfo.getUser());
    	return model;
    }
    
    @RequestMapping("grabar-aporte.html")
    public ModelAndView grabarAporte(@ModelAttribute("aporte") Articulo articulo){
    	ModelAndView model = new ModelAndView("aporte");
    	articulo.setIdUsuarioFk(userInfo.getUser());
    	articulo.setIdArchivoFk(archivoAporte);
    	return model;
    }
    
    @RequestMapping(value="file-aporte.html", method=RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) {
        try{
        	if (!file.isEmpty()) {
        		archivoAporte.setContenido(file.getBytes());
        		return "true";
           }        	
        }catch (IOException e) {
			return e.getMessage();
		}catch(Exception ex){
			return ex.getMessage();
        }
        return "false";    	
    }
}
