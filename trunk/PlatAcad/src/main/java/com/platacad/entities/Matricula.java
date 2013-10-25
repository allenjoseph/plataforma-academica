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
@Table(name = "matricula", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdMatriculaPk", query = "SELECT m FROM Matricula m WHERE m.idMatriculaPk = :idMatriculaPk"),
    @NamedQuery(name = "Matricula.findByIdCursoAperturadoFk", query = "SELECT m FROM Matricula m WHERE m.idCursoAperturadoFk = :idCursoAperturadoFk")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matricula_pk", nullable = false)
    private Integer idMatriculaPk;
    @Basic(optional = false)
    @Column(name = "id_curso_aperturado_fk", nullable = false)
    private int idCursoAperturadoFk;
    @Embedded
    private Auditoria auditoria;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;

    public Matricula() {
    }

    public Matricula(Integer idMatriculaPk) {
        this.idMatriculaPk = idMatriculaPk;
    }

    public Integer getIdMatriculaPk() {
        return idMatriculaPk;
    }

    public void setIdMatriculaPk(Integer idMatriculaPk) {
        this.idMatriculaPk = idMatriculaPk;
    }

    public int getIdCursoAperturadoFk() {
        return idCursoAperturadoFk;
    }

    public void setIdCursoAperturadoFk(int idCursoAperturadoFk) {
        this.idCursoAperturadoFk = idCursoAperturadoFk;
    }

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatriculaPk != null ? idMatriculaPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatriculaPk == null && other.idMatriculaPk != null) || (this.idMatriculaPk != null && !this.idMatriculaPk.equals(other.idMatriculaPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Matricula[ idMatriculaPk=" + idMatriculaPk + " ]";
    }
    
}
