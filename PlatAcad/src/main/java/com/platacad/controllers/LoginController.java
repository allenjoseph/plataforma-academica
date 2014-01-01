package com.platacad.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.platacad.model.commons.UserInfo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Matricula;
import com.platacad.model.enums.TipoRolEnum;
import com.platacad.services.GeneralService;
import com.platacad.services.GeneralServiceInterface;
import com.platacad.services.UsuarioService;
import com.platacad.services.UsuarioServiceInterface;

@Controller
@Scope("session")
public class LoginController {
	
	@Autowired
    UsuarioServiceInterface usuarioService;
	
	@Autowired
    GeneralServiceInterface generalService;
	
	@Autowired
    UserInfo userInfo;

	@RequestMapping("login.html")
    public String logon(){
    	return "logon";
    }
    
    @RequestMapping("success-login.html")  
    public View successLogin() {  
    	loadUserInfo();
    	return new RedirectView("inicio.html");
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
    
    @RequestMapping("success-logout.html")
    public View logoutOk(){    	
    	userInfo.closeSession();
    	return new RedirectView("login.html");  
    }
    
	public void loadUserInfo() {
		if(userInfo.getUser().getIdUsuarioPk() == null){
			Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	UserInfo.userId = user.toString();
	    	if(user instanceof UserDetails){
	    		UserInfo.userId = ((UserDetails) user).getUsername();
	    	}
	    	userInfo.setUser(usuarioService.getUsuario(UserInfo.userId));
	    	userInfo.setInicioSesion(new Date());
	    	
	    	List<CursoAperturado> cursosAperturados = new ArrayList<CursoAperturado>();
	    	
	    	Collection<? extends GrantedAuthority> authorities = ((UserDetails) user).getAuthorities();
	        for (GrantedAuthority grantedAuthority : authorities) {
	        	userInfo.getUser().setTotalMensajes(usuarioService.getTotalMensajes(UserInfo.userId, 1));
	        	
	            if (grantedAuthority.getAuthority().equals(TipoRolEnum.ALUMNO.getDescripcion())) {
	            		            	
	            	List<Matricula> cursosMatriculados = generalService.getCursosMatriculados(1, UserInfo.userId);
	            	cursosAperturados = new ArrayList<CursoAperturado>();
	    	        for(Matricula matricula : cursosMatriculados){
	    	        	cursosAperturados.add(matricula.getIdCursoAperturadoFk());
	    	        }
	    	        userInfo.getUser().setTotalExamenes(usuarioService.getTotalExamenes(UserInfo.userId, new Date()));
	    	        userInfo.getUser().setTotalTrabajos(usuarioService.getTotalTrabajos(UserInfo.userId, 1));
	    	        userInfo.getUser().setIsAlumno(Boolean.TRUE);
	    	        
	            } else if (grantedAuthority.getAuthority().equals(TipoRolEnum.DOCENTE.getDescripcion())) {
	            	
	            	userInfo.getUser().setIsDocente(Boolean.TRUE);
	            	cursosAperturados = generalService.getCursosACargo(1, UserInfo.userId);
	            	
	            } else if (grantedAuthority.getAuthority().equals(TipoRolEnum.ADMIN.getDescripcion())){
	            	
	            	userInfo.getUser().setIsAdministrativo(Boolean.TRUE);
	            	
	            }
	            break;
	        }
	        userInfo.setCursos(cursosAperturados);
		}
	}
}
