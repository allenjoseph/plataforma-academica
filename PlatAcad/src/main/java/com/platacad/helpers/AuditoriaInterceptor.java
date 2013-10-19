package com.platacad.helpers;

import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.method.handlermethod;
import com.platacad.entities.Auditoria;
import com.platacad.entities.Mensaje;
import com.platacad.to.MensajeTO;

public class AuditoriaInterceptor implements HandlerInterceptor{
	
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion: ----------------------------------------------------------------------------");		
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView model) throws Exception {
				
		System.out.println("postHandle: ----------------------------------------------------------------------------");
		for(Entry<String, Object> e : model.getModel().entrySet()){
			if(e.getValue().getClass() == Mensaje.class){
				Auditoria auditoria = (Auditoria) e.getValue(); 
				auditoria.setUsuarioAuditoria("0512013000");
				Mensaje msj = (Mensaje)auditoria;				
				System.out.println(msj.toString());
			}
		}	
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {	
		//HandlerMethod method = (HandlerMethod) obj;
		System.out.println("preHandle: ----------------------------------------------------------------------------");
		System.out.println(obj);
		//System.out.println(method);
		return true;
	}

}
