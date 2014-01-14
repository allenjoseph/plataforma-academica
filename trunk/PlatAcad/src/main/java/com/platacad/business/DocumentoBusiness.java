package com.platacad.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.platacad.model.entities.Archivo;
import com.platacad.model.entities.Documento;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.repositories.ArchivoRepository;
import com.platacad.repositories.DocumentoRepository;
import com.platacad.to.DocumentoTO;

@Component
public class DocumentoBusiness {
	
	@Resource
	DocumentoRepository documentoRepository;
	
	@Resource
	ArchivoRepository archivoRepository;	

	public Documento registrarDocumento(Documento documento) {
		documento.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		if(documento.getIdArchivoFk().getContenido() != null){
			Archivo archivo = documento.getIdArchivoFk();
			archivo.setEstado(EstadoEntidad.ACTIVO.getCodigo());
			archivo = archivoRepository.save(archivo);
			documento.setIdArchivoFk(archivo);
		}
		return documentoRepository.save(documento);
	}

	public List<Documento> obtenerDocumentos() {		
		return documentoRepository.findAll(new Sort(Direction.DESC, "idDocumento"));
	}

	public List<DocumentoTO> filtrarDocumento(String texto) {
		List<Documento> documentos = documentoRepository.filtrarDocumentos(texto);
		List<DocumentoTO> documentosTO = new ArrayList<DocumentoTO>();
		for(Documento doc : documentos){
			documentosTO.add(new DocumentoTO(doc.getIdDocumento(),doc.getTitulo(),doc.getIdArchivoFk().getIdArchivoPk()));
		}
		return documentosTO;
	}
	

}
