package com.platacad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.DocumentoBusiness;
import com.platacad.model.entities.Documento;
import com.platacad.to.DocumentoTO;

@Service
public class DocumentoService implements DocumentoServiceInterface{

	@Autowired
	DocumentoBusiness documentoBusiness;

	public Documento registrarDocumento(Documento documento) {
		return documentoBusiness.registrarDocumento(documento);
	}

	public List<Documento> obtenerDocumentos() {
		return documentoBusiness.obtenerDocumentos();
	}

	public List<DocumentoTO> filtrarDocumento(String texto) {
		return documentoBusiness.filtrarDocumento(texto);
	}
}
