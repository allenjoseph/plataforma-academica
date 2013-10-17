/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "tipos", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tipos.findAll", query = "SELECT t FROM Tipos t"),
    @NamedQuery(name = "Tipos.findByIdTiposPk", query = "SELECT t FROM Tipos t WHERE t.idTiposPk = :idTiposPk"),
    @NamedQuery(name = "Tipos.findByDescripcion", query = "SELECT t FROM Tipos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipos.findByParametro", query = "SELECT t FROM Tipos t WHERE t.parametro = :parametro"),
    @NamedQuery(name = "Tipos.findByModificacionFecha", query = "SELECT t FROM Tipos t WHERE t.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Tipos.findByModificacionUsuario", query = "SELECT t FROM Tipos t WHERE t.modificacionUsuario = :modificacionUsuario")})
public class Tipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipos_pk", nullable = false)
    private Integer idTiposPk;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Column(name = "parametro", length = 255)
    private String parametro;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @OneToMany(mappedBy = "estado")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "tipo")
    private List<TrabajoEncargado> trabajoEncargadoList;
    @OneToMany(mappedBy = "tipo")
    private List<Documento> documentoList;
    @OneToMany(mappedBy = "tipo")
    private List<Curso> cursoList;
    @OneToMany(mappedBy = "tipoExamen")
    private List<Examen> examenList;
    @OneToMany(mappedBy = "tipoPeriodo")
    private List<Ciclo> cicloList;

    public Tipos() {
    }

    public Tipos(Integer idTiposPk) {
        this.idTiposPk = idTiposPk;
    }

    public Tipos(Integer idTiposPk, Date modificacionFecha, String modificacionUsuario) {
        this.idTiposPk = idTiposPk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdTiposPk() {
        return idTiposPk;
    }

    public void setIdTiposPk(Integer idTiposPk) {
        this.idTiposPk = idTiposPk;
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<TrabajoEncargado> getTrabajoEncargadoList() {
        return trabajoEncargadoList;
    }

    public void setTrabajoEncargadoList(List<TrabajoEncargado> trabajoEncargadoList) {
        this.trabajoEncargadoList = trabajoEncargadoList;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public List<Ciclo> getCicloList() {
        return cicloList;
    }

    public void setCicloList(List<Ciclo> cicloList) {
        this.cicloList = cicloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiposPk != null ? idTiposPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipos)) {
            return false;
        }
        Tipos other = (Tipos) object;
        if ((this.idTiposPk == null && other.idTiposPk != null) || (this.idTiposPk != null && !this.idTiposPk.equals(other.idTiposPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Tipos[ idTiposPk=" + idTiposPk + " ]";
    }
    
}
