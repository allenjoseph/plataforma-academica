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
@Table(name = "examen", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdExamen", query = "SELECT e FROM Examen e WHERE e.idExamen = :idExamen"),
    @NamedQuery(name = "Examen.findByFechaExamen", query = "SELECT e FROM Examen e WHERE e.fechaExamen = :fechaExamen")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_examen", nullable = false)
    private Integer idExamen;
    @Column(name = "fecha_examen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExamen;
    @JoinColumn(name = "tipo_examen", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipoExamen;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoFk;

    public Examen() {
    }

    public Examen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public Tipos getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(Tipos tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Curso getIdCursoFk() {
        return idCursoFk;
    }

    public void setIdCursoFk(Curso idCursoFk) {
        this.idCursoFk = idCursoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Examen[ idExamen=" + idExamen + " ]";
    }
    
}