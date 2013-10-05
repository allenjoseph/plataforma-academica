/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @NamedQuery(name = "Curso.findByCreditos", query = "SELECT c FROM Curso c WHERE c.creditos = :creditos")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_curso_pk", nullable = false)
    private Integer idCursoPk;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "creditos")
    private Integer creditos;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipo;
    @OneToMany(mappedBy = "idCursoFk")
    private List<Articulo> articuloList;
    @OneToMany(mappedBy = "idCursoFk")
    private List<TrabajoEncargado> trabajoEncargadoList;
    @OneToMany(mappedBy = "idCursoFk")
    private List<Examen> examenList;
    @OneToMany(mappedBy = "idCursoDestinoFk")
    private List<Mensaje> mensajeList;
    @OneToMany(mappedBy = "idCursoFk")
    private List<Matricula> matriculaList;

    public Curso() {
    }

    public Curso(Integer idCursoPk) {
        this.idCursoPk = idCursoPk;
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

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
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

    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
