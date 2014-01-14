package com.platacad.services;

import java.util.List;

import com.platacad.model.entities.Documento;
import com.platacad.to.DocumentoTO;

public interface DocumentoServiceInterface {

	Documento registrarDocumento(Documento documento);

	List<Documento> obtenerDocumentos();

	List<DocumentoTO> filtrarDocumento(String texto);

}
