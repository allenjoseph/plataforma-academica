/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
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

/**
 *
 * @author allen
 */
@Entity
@Table(name = "matricula", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCorrelativo", query = "SELECT m FROM Matricula m WHERE m.correlativo = :correlativo")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "correlativo", nullable = false)
    private Integer correlativo;
    @JoinColumn(name = "id_ciclo_fk", referencedColumnName = "id_ciclo_pk")
    @ManyToOne
    private Ciclo idCicloFk;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoFk;

    public Matricula() {
    }

    public Matricula(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Ciclo getIdCicloFk() {
        return idCicloFk;
    }

    public void setIdCicloFk(Ciclo idCicloFk) {
        this.idCicloFk = idCicloFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
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
        hash += (correlativo != null ? correlativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.correlativo == null && other.correlativo != null) || (this.correlativo != null && !this.correlativo.equals(other.correlativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Matricula[ correlativo=" + correlativo + " ]";
    }
    
}
