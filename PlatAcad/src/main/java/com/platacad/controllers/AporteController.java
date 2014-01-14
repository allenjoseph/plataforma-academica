package com.platacad.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.platacad.helpers.SystemMessage;
import com.platacad.helpers.Util;
import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.Archivo;
import com.platacad.model.entities.Articulo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.services.AporteServiceInterface;
import com.platacad.services.UsuarioServiceInterface;

@Controller
public class AporteController {
	
	@Autowired
    UsuarioServiceInterface usuarioService;
	
	@Autowired
	AporteServiceInterface aporteService;
	
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
    public View grabarAporte(@ModelAttribute("aporte") Articulo aporte){
    	try{
    		aporte.setIdUsuarioFk(userInfo.getUser());
        	if(archivoAporte.getContenido() != null){
        		aporte.setIdArchivoFk(archivoAporte);
        		Articulo articulo = aporteService.registrarAporte(aporte);
        		Util.mensaje = "Se registro Aporte N° "+articulo.getIdArticuloPk()+" satisfactoriamente.";	
        	}else{
        		Util.error = SystemMessage.PROCESS_ERROR;
        	}			
		}catch(Exception ex){
			Util.error = SystemMessage.PROCESS_ERROR;
		}		
		return new RedirectView("aportes.html");
    }
    
    @RequestMapping(value = "ver-aporte.html")
    public ModelAndView verAporte(@ModelAttribute("aporteSelected") Articulo articulo){
    	ModelAndView model = new ModelAndView("aporteView");
    	Articulo aporte = aporteService.getAporte(articulo.getIdArticuloPk());
    	aporte.setContenidoValue(new String(aporte.getContenido()));
    	model.addObject("aporte", aporte);
    	model.addObject("user", userInfo.getUser());
    	return model;
    }
    
    @RequestMapping("aportes.html")
    public ModelAndView listarTodosAportes(){
    	ModelAndView model = Util.buildModel("listaAportes");
    	List<Articulo> lista = aporteService.obtenerAportes();
    	model.addObject("user", userInfo.getUser());
    	model.addObject("aportes", lista);
    	model.addObject("curso", new CursoAperturado());
    	model.addObject("cursos", userInfo.getCursos());
    	return model;
    }
    
    @RequestMapping("listar-aportes.html")
    public ModelAndView listarAportes(@ModelAttribute("cursoId") Integer cursoId){
    	ModelAndView model = new ModelAndView("listaAportesByCurso");
    	List<Articulo> lista = aporteService.getAportes(cursoId);
    	model.addObject("user", userInfo.getUser());
    	model.addObject("aportes", lista);  
    	model.addObject("aporteSelected", new Articulo());
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
