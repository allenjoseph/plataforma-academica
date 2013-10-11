package com.platacad.helpers;

import java.util.Date;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.platacad.entities.Auditoria;
import com.platacad.to.MensajeTO;
import com.platacad.to.UsuarioTO;

public class AuditoriaInterceptor implements HandlerInterceptor{

	private static final Logger logger = Logger.getLogger(AuditoriaInterceptor.class);
	
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion: ----------------------------------------------------------------------------");		
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView model) throws Exception {
				
		System.out.println("postHandle: ----------------------------------------------------------------------------");
		for(Entry<String, Object> e : model.getModel().entrySet()){
			if(e.getValue().getClass() == MensajeTO.class){
				Auditoria auditoria = (Auditoria) e.getValue(); 
				auditoria.setUsuarioAuditoria("Hola Mundo");
				MensajeTO msj = (MensajeTO)auditoria;
				
				System.out.println(auditoria.getUsuarioAuditoria());
				System.out.println(msj.getAsunto());
			}
		}	
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {	
		
		System.out.println("preHandle: ----------------------------------------------------------------------------");
		
		return true;
	}

}
