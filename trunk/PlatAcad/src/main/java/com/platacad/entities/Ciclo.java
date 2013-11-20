/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

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
    
    @JoinColumn(name = "tipo_periodo", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipoPeriodo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCicloFk")
    private List<CursoAperturado> cursoAperturadoList;
    
    @OneToMany(mappedBy = "idCicloFk")
    private List<Matricula> matriculaList;

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
	
    public Tipos getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Tipos tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public List<CursoAperturado> getCursoAperturadoList() {
        return cursoAperturadoList;
    }

    public void setCursoAperturadoList(List<CursoAperturado> cursoAperturadoList) {
        this.cursoAperturadoList = cursoAperturadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCicloPk != null ? idCicloPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.idCicloPk == null && other.idCicloPk != null) || (this.idCicloPk != null && !this.idCicloPk.equals(other.idCicloPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Ciclo[ idCicloPk=" + idCicloPk + " ]";
    }
    
}
