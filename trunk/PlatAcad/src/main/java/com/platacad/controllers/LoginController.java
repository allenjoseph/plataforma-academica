package com.platacad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

	@RequestMapping("login.html")
    public String logon(){
    	return "logon";
    }
    
    @RequestMapping("success-login.html")  
    public View successLogin() {  
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
    
    @RequestMapping("logout.html")
    public String logout(){
    	return "logon";
    }
}
