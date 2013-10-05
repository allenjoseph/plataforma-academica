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
@Table(name = "trabajo_encargado", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "TrabajoEncargado.findAll", query = "SELECT t FROM TrabajoEncargado t"),
    @NamedQuery(name = "TrabajoEncargado.findByIdTrabajoPk", query = "SELECT t FROM TrabajoEncargado t WHERE t.idTrabajoPk = :idTrabajoPk"),
    @NamedQuery(name = "TrabajoEncargado.findByTitulo", query = "SELECT t FROM TrabajoEncargado t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "TrabajoEncargado.findByFechaCreacion", query = "SELECT t FROM TrabajoEncargado t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TrabajoEncargado.findByFechaPresentacion", query = "SELECT t FROM TrabajoEncargado t WHERE t.fechaPresentacion = :fechaPresentacion")})
public class TrabajoEncargado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_trabajo_pk", nullable = false)
    private Integer idTrabajoPk;
    @Column(name = "titulo", length = 255)
    private String titulo;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_presentacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPresentacion;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipo;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoFk;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @OneToMany(mappedBy = "idTrabajoFk")
    private List<DetalleTrabajo> detalleTrabajoList;

    public TrabajoEncargado() {
    }

    public TrabajoEncargado(Integer idTrabajoPk) {
        this.idTrabajoPk = idTrabajoPk;
    }

    public Integer getIdTrabajoPk() {
        return idTrabajoPk;
    }

    public void setIdTrabajoPk(Integer idTrabajoPk) {
        this.idTrabajoPk = idTrabajoPk;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public Curso getIdCursoFk() {
        return idCursoFk;
    }

    public void setIdCursoFk(Curso idCursoFk) {
        this.idCursoFk = idCursoFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public List<DetalleTrabajo> getDetalleTrabajoList() {
        return detalleTrabajoList;
    }

    public void setDetalleTrabajoList(List<DetalleTrabajo> detalleTrabajoList) {
        this.detalleTrabajoList = detalleTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajoPk != null ? idTrabajoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajoEncargado)) {
            return false;
        }
        TrabajoEncargado other = (TrabajoEncargado) object;
        if ((this.idTrabajoPk == null && other.idTrabajoPk != null) || (this.idTrabajoPk != null && !this.idTrabajoPk.equals(other.idTrabajoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.TrabajoEncargado[ idTrabajoPk=" + idTrabajoPk + " ]";
    }
    
}
