/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "estados", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByIdEstadoPk", query = "SELECT e FROM Estados e WHERE e.idEstadoPk = :idEstadoPk"),
    @NamedQuery(name = "Estados.findByDescripcion", query = "SELECT e FROM Estados e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estados.findByParametro", query = "SELECT e FROM Estados e WHERE e.parametro = :parametro")})
public class Estados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_pk", nullable = false)
    private Integer idEstadoPk;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "parametro", nullable = false, length = 255)
    private String parametro;
    @Embedded
    private Auditoria auditoria;

    public Estados() {
    }

    public Estados(Integer idEstadoPk) {
        this.idEstadoPk = idEstadoPk;
    }
    
    public Integer getIdEstadoPk() {
        return idEstadoPk;
    }

    public void setIdEstadoPk(Integer idEstadoPk) {
        this.idEstadoPk = idEstadoPk;
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

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPk != null ? idEstadoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.idEstadoPk == null && other.idEstadoPk != null) || (this.idEstadoPk != null && !this.idEstadoPk.equals(other.idEstadoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Estados[ idEstadoPk=" + idEstadoPk + " ]";
    }
    
}
