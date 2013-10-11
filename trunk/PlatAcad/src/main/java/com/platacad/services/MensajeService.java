package com.platacad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.MensajeBusiness;
import com.platacad.to.MensajeTO;

@Service
public class MensajeService implements MensajeServiceInterface{
	
	@Autowired
	private MensajeBusiness mensajeBusiness;

	public boolean enviarMensaje(MensajeTO mensajeTO) {
		return mensajeBusiness.enviarMensaje(mensajeTO);
	}

}
