package com.platacad.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.platacad.model.commons.UserInfo;
import com.platacad.model.enums.TipoRolEnum;
import com.platacad.services.UsuarioService;

@Controller
@Scope("session")
public class LoginController {
	
	@Autowired
    UsuarioService usuarioService;
	
	@Autowired
    UserInfo userInfo;

	@RequestMapping("login.html")
    public String logon(){
    	return "logon";
    }
    
    @RequestMapping("success-login.html")  
    public View successLogin() {  
    	loadUserInfo();
    	if(userInfo.getUser().getRol().equals(TipoRolEnum.ALUMNO.getCodigo())){
    		return new RedirectView("inicio.html");  
    	}else if(userInfo.getUser().getRol().equals(TipoRolEnum.DOCENTE.getCodigo())){
    		return new RedirectView("inicio-docente.html");
    	}
        return new RedirectView("login.html");
    } 

    @RequestMapping("process-login.html")  
    public View processLogin() {  
        return new RedirectView("inicio.html");  
    } 
    
    @RequestMapping("error-login.html")
    public ModelAndView errorLogon(){
    	ModelAndView modelAndView = new ModelAndView("logon");  
        modelAndView.addObject("error", true);  
        return modelAndView;  
    }
    
    @RequestMapping("logout.html")
    public String logout(){    	
    	userInfo.closeSession();
    	return "logon";
    }
    
	public void loadUserInfo() {
		if(userInfo.getUser().getIdUsuarioPk() == null){
			Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	String userName = user.toString();
	    	if(user instanceof UserDetails){
	    		userName = ((UserDetails) user).getUsername();
	    	}
	    	userInfo.setUser(usuarioService.getUsuario(userName));
	    	userInfo.setInicioSesion(new Date());
		}
	}
}
