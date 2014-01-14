package com.platacad.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.platacad.model.entities.Documento;
import com.platacad.services.DocumentoServiceInterface;
import com.platacad.to.DocumentoTO;

@Controller
public class DocumentoController {
	
    @Autowired
    UserInfo userInfo;
    
    @Autowired
    DocumentoServiceInterface documentoService;
    
    private Archivo archivoDocumento;

	@RequestMapping("documento.html")
    public ModelAndView nuevoDocumento(){
    	ModelAndView model = Util.buildModel("documento");
    	model.addObject("user", userInfo.getUser());
    	model.addObject("documento", new Documento());
    	archivoDocumento = new Archivo();
    	return model;
    }
    
    @RequestMapping(value="file-documento.html", method=RequestMethod.POST)
    @ResponseBody
    public String handleFormUpload(@RequestParam("file") MultipartFile file) {
        try{
        	if (!file.isEmpty()) {
        		archivoDocumento.setContenido(file.getBytes());
        		return "true";
           }        	
        }catch (IOException e) {
			return e.getMessage();
		}catch(Exception ex){
			return ex.getMessage();
        }
        return "false";    	
    }
    
    @RequestMapping("subir-documento.html")
    public View registrarDocumento(@ModelAttribute("documento") Documento documento){
    	try{
        	if(archivoDocumento.getContenido() != null){
        		archivoDocumento.setIdUsuarioFk(userInfo.getUser());
        		documento.setIdArchivoFk(archivoDocumento);
        		documento = documentoService.registrarDocumento(documento);
        		Util.mensaje = "Se registro Documento N° "+documento.getIdDocumento()+" satisfactoriamente.";	
        	}else{
        		Util.error = SystemMessage.PROCESS_ERROR;
        	}	
		}catch(Exception ex){
			Util.error = SystemMessage.PROCESS_ERROR;
		}
    	return new RedirectView("documentos.html");
    }
    
    @RequestMapping("documentos.html")
    public ModelAndView listaDocumentos(){
    	ModelAndView model = Util.buildModel("listaDocumentos");
    	model.addObject("user", userInfo.getUser());
    	model.addObject("documentos",documentoService.obtenerDocumentos());
    	return model;
    }
    
    @RequestMapping(value = "get-documentos.json", method = RequestMethod.GET)
    public @ResponseBody List<DocumentoTO> filtrarDocumento(@RequestParam("texto") String texto){
    	List<DocumentoTO> documentos = documentoService.filtrarDocumento(texto);
    	return documentos;    	
    }
}
