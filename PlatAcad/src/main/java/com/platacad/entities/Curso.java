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
@Table(name = "curso", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCursoPk", query = "SELECT c FROM Curso c WHERE c.idCursoPk = :idCursoPk"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByCreditos", query = "SELECT c FROM Curso c WHERE c.creditos = :creditos"),
    @NamedQuery(name = "Curso.findByModificacionFecha", query = "SELECT c FROM Curso c WHERE c.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Curso.findByModificacionUsuario", query = "SELECT c FROM Curso c WHERE c.modificacionUsuario = :modificacionUsuario")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_pk", nullable = false)
    private Integer idCursoPk;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "creditos")
    private Integer creditos;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @OneToMany(mappedBy = "idCursoDestinoFk")
    private List<Mensaje> mensajeList;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoFk")
    private List<CursoAperturado> cursoAperturadoList;

    public Curso() {
    }

    public Curso(Integer idCursoPk) {
        this.idCursoPk = idCursoPk;
    }

    public Curso(Integer idCursoPk, Date modificacionFecha, String modificacionUsuario) {
        this.idCursoPk = idCursoPk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdCursoPk() {
        return idCursoPk;
    }

    public void setIdCursoPk(Integer idCursoPk) {
        this.idCursoPk = idCursoPk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
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

    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
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
        hash += (idCursoPk != null ? idCursoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCursoPk == null && other.idCursoPk != null) || (this.idCursoPk != null && !this.idCursoPk.equals(other.idCursoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Curso[ idCursoPk=" + idCursoPk + " ]";
    }
    
}