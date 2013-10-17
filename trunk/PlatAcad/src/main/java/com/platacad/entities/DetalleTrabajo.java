/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_trabajo", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleTrabajo.findAll", query = "SELECT d FROM DetalleTrabajo d"),
    @NamedQuery(name = "DetalleTrabajo.findByIdDetallePk", query = "SELECT d FROM DetalleTrabajo d WHERE d.idDetallePk = :idDetallePk"),
    @NamedQuery(name = "DetalleTrabajo.findByModificacionFecha", query = "SELECT d FROM DetalleTrabajo d WHERE d.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "DetalleTrabajo.findByModificacionUsuario", query = "SELECT d FROM DetalleTrabajo d WHERE d.modificacionUsuario = :modificacionUsuario")})
public class DetalleTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_pk", nullable = false)
    private Integer idDetallePk;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
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

    public DetalleTrabajo(Integer idDetallePk, Date modificacionFecha, String modificacionUsuario) {
        this.idDetallePk = idDetallePk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdDetallePk() {
        return idDetallePk;
    }

    public void setIdDetallePk(Integer idDetallePk) {
        this.idDetallePk = idDetallePk;
    }

    public Date getModificacionFecha() {
        return modificacionFecha;
    }

    public void setModificacionFecha(Date modificacionFecha) {
        this.modificacionFecha = modificacionFecha;
    }

    public String getModificacionUsuario() {
        return modificacionUsuario;
    }

    public void setModificacionUsuario(String modificacionUsuario) {
        this.modificacionUsuario = modificacionUsuario;
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
