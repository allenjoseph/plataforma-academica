/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

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
    
}
