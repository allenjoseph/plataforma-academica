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
@Table(name = "tipos", catalog = "platacad", schema = "")
public class Tipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipos_pk", nullable = false)
    private Integer idTiposPk;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Column(name = "parametro", length = 255)
    private String parametro;
    @Column(name = "tabla_referencia", length = 255)
    private String tablaReferencia;
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
    @OneToMany(mappedBy = "tipoExamen")
    private List<Examen> examenList;
    @OneToMany(mappedBy = "tipoPeriodo")
    private List<Ciclo> cicloList;

    public Tipos() {
    }

    public Tipos(Integer idTiposPk) {
        this.idTiposPk = idTiposPk;
    }

    public Integer getIdTiposPk() {
        return idTiposPk;
    }

    public void setIdTiposPk(Integer idTiposPk) {
        this.idTiposPk = idTiposPk;
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

    public String getTablaReferencia() {
		return tablaReferencia;
	}

	public void setTablaReferencia(String tablaReferencia) {
		this.tablaReferencia = tablaReferencia;
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
        hash += (idTiposPk != null ? idTiposPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipos)) {
            return false;
        }
        Tipos other = (Tipos) object;
        if ((this.idTiposPk == null && other.idTiposPk != null) || (this.idTiposPk != null && !this.idTiposPk.equals(other.idTiposPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Tipos[ idTiposPk=" + idTiposPk + " ]";
    }
    
}
