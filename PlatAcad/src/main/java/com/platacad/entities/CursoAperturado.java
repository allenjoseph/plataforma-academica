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
@Table(name = "curso_aperturado", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "CursoAperturado.findAll", query = "SELECT c FROM CursoAperturado c"),
    @NamedQuery(name = "CursoAperturado.findByIdCursoAperturado", query = "SELECT c FROM CursoAperturado c WHERE c.idCursoAperturado = :idCursoAperturado"),
    @NamedQuery(name = "CursoAperturado.findByModificacionFecha", query = "SELECT c FROM CursoAperturado c WHERE c.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "CursoAperturado.findByModificacionUsuario", query = "SELECT c FROM CursoAperturado c WHERE c.modificacionUsuario = :modificacionUsuario")})
public class CursoAperturado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_aperturado", nullable = false)
    private Integer idCursoAperturado;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<Articulo> articuloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<TrabajoEncargado> trabajoEncargadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<Examen> examenList;
    @JoinColumn(name = "id_docente_fk", referencedColumnName = "id_usuario_pk", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idDocenteFk;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk", nullable = false)
    @ManyToOne(optional = false)
    private Curso idCursoFk;
    @JoinColumn(name = "id_ciclo_fk", referencedColumnName = "id_ciclo_pk", nullable = false)
    @ManyToOne(optional = false)
    private Ciclo idCicloFk;

    public CursoAperturado() {
    }

    public CursoAperturado(Integer idCursoAperturado) {
        this.idCursoAperturado = idCursoAperturado;
    }

    public CursoAperturado(Integer idCursoAperturado, Date modificacionFecha, String modificacionUsuario) {
        this.idCursoAperturado = idCursoAperturado;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdCursoAperturado() {
        return idCursoAperturado;
    }

    public void setIdCursoAperturado(Integer idCursoAperturado) {
        this.idCursoAperturado = idCursoAperturado;
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

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public List<TrabajoEncargado> getTrabajoEncargadoList() {
        return trabajoEncargadoList;
    }

    public void setTrabajoEncargadoList(List<TrabajoEncargado> trabajoEncargadoList) {
        this.trabajoEncargadoList = trabajoEncargadoList;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public Usuario getIdDocenteFk() {
        return idDocenteFk;
    }

    public void setIdDocenteFk(Usuario idDocenteFk) {
        this.idDocenteFk = idDocenteFk;
    }

    public Curso getIdCursoFk() {
        return idCursoFk;
    }

    public void setIdCursoFk(Curso idCursoFk) {
        this.idCursoFk = idCursoFk;
    }

    public Ciclo getIdCicloFk() {
        return idCicloFk;
    }

    public void setIdCicloFk(Ciclo idCicloFk) {
        this.idCicloFk = idCicloFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoAperturado != null ? idCursoAperturado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoAperturado)) {
            return false;
        }
        CursoAperturado other = (CursoAperturado) object;
        if ((this.idCursoAperturado == null && other.idCursoAperturado != null) || (this.idCursoAperturado != null && !this.idCursoAperturado.equals(other.idCursoAperturado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.CursoAperturado[ idCursoAperturado=" + idCursoAperturado + " ]";
    }
    
}
