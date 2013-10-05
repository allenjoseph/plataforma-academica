/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "detalle_trabajo", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleTrabajo.findAll", query = "SELECT d FROM DetalleTrabajo d"),
    @NamedQuery(name = "DetalleTrabajo.findByIdDetallePk", query = "SELECT d FROM DetalleTrabajo d WHERE d.idDetallePk = :idDetallePk")})
public class DetalleTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detalle_pk", nullable = false)
    private Integer idDetallePk;
    @JoinColumn(name = "id_archivo_fk", referencedColumnName = "id_archivo_pk")
    @ManyToOne
    private Archivo idArchivoFk;
    @JoinColumn(name = "id_trabajo_fk", referencedColumnName = "id_trabajo_pk")
    @ManyToOne
    private TrabajoEncargado idTrabajoFk;

    public DetalleTrabajo() {
    }

    public DetalleTrabajo(Integer idDetallePk) {
        this.idDetallePk = idDetallePk;
    }

    public Integer getIdDetallePk() {
        return idDetallePk;
    }

    public void setIdDetallePk(Integer idDetallePk) {
        this.idDetallePk = idDetallePk;
    }

    public Archivo getIdArchivoFk() {
        return idArchivoFk;
    }

    public void setIdArchivoFk(Archivo idArchivoFk) {
        this.idArchivoFk = idArchivoFk;
    }

    public TrabajoEncargado getIdTrabajoFk() {
        return idTrabajoFk;
    }

    public void setIdTrabajoFk(TrabajoEncargado idTrabajoFk) {
        this.idTrabajoFk = idTrabajoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePk != null ? idDetallePk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrabajo)) {
            return false;
        }
        DetalleTrabajo other = (DetalleTrabajo) object;
        if ((this.idDetallePk == null && other.idDetallePk != null) || (this.idDetallePk != null && !this.idDetallePk.equals(other.idDetallePk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.DetalleTrabajo[ idDetallePk=" + idDetallePk + " ]";
    }
    
}
