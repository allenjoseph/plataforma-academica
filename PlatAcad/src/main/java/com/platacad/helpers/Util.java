package com.platacad.helpers;

import org.springframework.web.servlet.ModelAndView;

public class Util {

	public static String error = "";
	public static String mensaje = "";
	
	public static ModelAndView buildModel(String vista) {
		ModelAndView model = new ModelAndView(vista);
		model.addObject("error", error);
		model.addObject("mensaje", mensaje);
		return model;
	}


}
