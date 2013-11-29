/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "parametros", catalog = "platacad", schema = "")
public class Parametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro_pk", nullable = false)
    private Integer idParametroPk;
    
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    
    @Column(name = "parametro", length = 255)
    private String parametro;
    
    @Column(name = "referencia", length = 255)
    private String referencia;
    
    @Embedded
    private Auditoria auditoria;
    
    @OneToMany(mappedBy = "estado")
    private List<Usuario> usuarioList;
    
    @OneToMany(mappedBy = "tipo")
    private List<TrabajoEncargado> trabajoEncargadoList;
    
    @OneToMany(mappedBy = "tipo")
    private List<Documento> documentoList;
    
    @OneToMany(mappedBy = "tipo")
    private List<Curso> cursoList;
    
    @OneToMany(mappedBy = "tipo")
    private List<Examen> examenList;
    
    @OneToMany(mappedBy = "tipo")
    private List<Ciclo> cicloList;

    public Parametros() {
    }

    public Parametros(Integer idParametroPk) {
        this.idParametroPk = idParametroPk;
    }

    public Integer getIdParametroPk() {
        return idParametroPk;
    }

    public void setIdParametroPk(Integer idParametroPk) {
        this.idParametroPk = idParametroPk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<TrabajoEncargado> getTrabajoEncargadoList() {
        return trabajoEncargadoList;
    }

    public void setTrabajoEncargadoList(List<TrabajoEncargado> trabajoEncargadoList) {
        this.trabajoEncargadoList = trabajoEncargadoList;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public List<Ciclo> getCicloList() {
        return cicloList;
    }

    public void setCicloList(List<Ciclo> cicloList) {
        this.cicloList = cicloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametroPk != null ? idParametroPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.idParametroPk == null && other.idParametroPk != null) || (this.idParametroPk != null && !this.idParametroPk.equals(other.idParametroPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Parametros[ idParametroPk=" + idParametroPk + " ]";
    }
    
}
