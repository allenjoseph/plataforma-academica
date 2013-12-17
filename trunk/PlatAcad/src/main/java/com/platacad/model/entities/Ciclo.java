/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ciclo", catalog = "platacad", schema = "")
public class Ciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciclo_pk", nullable = false)
    private Integer idCicloPk;
    
    @Column(name = "anio")
    private Integer anio;
    
    @Embedded
    private Auditoria auditoria;
    
    @Column(name = "tipo_param")
    private Integer tipo;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCicloFk")
    private List<CursoAperturado> cursoAperturadoList;

    public Ciclo() {
    }

    public Ciclo(Integer idCicloPk) {
        this.idCicloPk = idCicloPk;
    }

    public Integer getIdCicloPk() {
        return idCicloPk;
    }

    public void setIdCicloPk(Integer idCicloPk) {
        this.idCicloPk = idCicloPk;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<CursoAperturado> getCursoAperturadoList() {
        return cursoAperturadoList;
    }

    public void setCursoAperturadoList(List<CursoAperturado> cursoAperturadoList) {
        this.cursoAperturadoList = cursoAperturadoList;
    }

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

    
}
