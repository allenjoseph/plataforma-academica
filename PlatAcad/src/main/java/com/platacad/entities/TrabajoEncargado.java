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
    @NamedQuery(name = "TrabajoEncargado.findByFechaPresentacion", query = "SELECT t FROM TrabajoEncargado t WHERE t.fechaPresentacion = :fechaPresentacion"),
    @NamedQuery(name = "TrabajoEncargado.findByEstado", query = "SELECT t FROM TrabajoEncargado t WHERE t.estado = :estado"),
    @NamedQuery(name = "TrabajoEncargado.findByModificacionFecha", query = "SELECT t FROM TrabajoEncargado t WHERE t.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "TrabajoEncargado.findByModificacionUsuario", query = "SELECT t FROM TrabajoEncargado t WHERE t.modificacionUsuario = :modificacionUsuario")})
public class TrabajoEncargado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private int estado;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos tipo;
    @JoinColumn(name = "id_curso_aperturado_fk", referencedColumnName = "id_curso_aperturado", nullable = false)
    @ManyToOne(optional = false)
    private CursoAperturado idCursoAperturadoFk;
    @OneToMany(mappedBy = "idTrabajoFk")
    private List<DetalleTrabajo> detalleTrabajoList;

    public TrabajoEncargado() {
    }

    public TrabajoEncargado(Integer idTrabajoPk) {
        this.idTrabajoPk = idTrabajoPk;
    }

    public TrabajoEncargado(Integer idTrabajoPk, int estado, Date modificacionFecha, String modificacionUsuario) {
        this.idTrabajoPk = idTrabajoPk;
        this.estado = estado;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public CursoAperturado getIdCursoAperturadoFk() {
        return idCursoAperturadoFk;
    }

    public void setIdCursoAperturadoFk(CursoAperturado idCursoAperturadoFk) {
        this.idCursoAperturadoFk = idCursoAperturadoFk;
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
