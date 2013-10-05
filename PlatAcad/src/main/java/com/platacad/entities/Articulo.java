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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "articulo", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdArticuloPk", query = "SELECT a FROM Articulo a WHERE a.idArticuloPk = :idArticuloPk"),
    @NamedQuery(name = "Articulo.findByTitulo", query = "SELECT a FROM Articulo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Articulo.findByFechaCreacion", query = "SELECT a FROM Articulo a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Articulo.findByFechaModificacion", query = "SELECT a FROM Articulo a WHERE a.fechaModificacion = :fechaModificacion")})
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_articulo_pk", nullable = false)
    private Integer idArticuloPk;
    @Column(name = "titulo", length = 255)
    private String titulo;
    @Lob
    @Column(name = "contenido")
    private byte[] contenido;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoFk;
    @JoinColumn(name = "id_archivo_fk", referencedColumnName = "id_archivo_pk")
    @ManyToOne
    private Archivo idArchivoFk;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @OneToMany(mappedBy = "idArticuloFk")
    private List<Comentario> comentarioList;

    public Articulo() {
    }

    public Articulo(Integer idArticuloPk) {
        this.idArticuloPk = idArticuloPk;
    }

    public Integer getIdArticuloPk() {
        return idArticuloPk;
    }

    public void setIdArticuloPk(Integer idArticuloPk) {
        this.idArticuloPk = idArticuloPk;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Curso getIdCursoFk() {
        return idCursoFk;
    }

    public void setIdCursoFk(Curso idCursoFk) {
        this.idCursoFk = idCursoFk;
    }

    public Archivo getIdArchivoFk() {
        return idArchivoFk;
    }

    public void setIdArchivoFk(Archivo idArchivoFk) {
        this.idArchivoFk = idArchivoFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticuloPk != null ? idArticuloPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticuloPk == null && other.idArticuloPk != null) || (this.idArticuloPk != null && !this.idArticuloPk.equals(other.idArticuloPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Articulo[ idArticuloPk=" + idArticuloPk + " ]";
    }
    
}
