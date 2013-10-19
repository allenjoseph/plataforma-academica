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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "usuario", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuarioPk", query = "SELECT u FROM Usuario u WHERE u.idUsuarioPk = :idUsuarioPk"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuario.findByApellidoPaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Usuario.findByApellidoMaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Usuario.findByModificacionFecha", query = "SELECT u FROM Usuario u WHERE u.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Usuario.findByModificacionUsuario", query = "SELECT u FROM Usuario u WHERE u.modificacionUsuario = :modificacionUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario_pk", nullable = false, length = 10)
    private String idUsuarioPk;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "nombres", length = 255)
    private String nombres;
    @Column(name = "apellido_paterno", length = 255)
    private String apellidoPaterno;
    @Column(name = "apellido_materno", length = 255)
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Articulo> articuloList;
    @JoinColumn(name = "estado", referencedColumnName = "id_tipos_pk")
    @ManyToOne
    private Tipos estado;
    @JoinColumn(name = "id_rol_fk", referencedColumnName = "id_rol_pk")
    @ManyToOne
    private Rol idRolFk;
    @OneToMany(mappedBy = "idUsuarioDestinoFk")
    private List<Mensaje> mensajeList;
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Mensaje> mensajeList1;
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Comentario> comentarioList;
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Matricula> matriculaList;
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Archivo> archivoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocenteFk")
    private List<CursoAperturado> cursoAperturadoList;
       
    public Usuario() {
    }

    public Usuario(String idUsuarioPk) {
        this.idUsuarioPk = idUsuarioPk;
    }

    public Usuario(String idUsuarioPk, Date modificacionFecha, String modificacionUsuario) {
        this.idUsuarioPk = idUsuarioPk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public String getIdUsuarioPk() {
        return idUsuarioPk;
    }

    public void setIdUsuarioPk(String idUsuarioPk) {
        this.idUsuarioPk = idUsuarioPk;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public Tipos getEstado() {
        return estado;
    }

    public void setEstado(Tipos estado) {
        this.estado = estado;
    }

    public Rol getIdRolFk() {
        return idRolFk;
    }

    public void setIdRolFk(Rol idRolFk) {
        this.idRolFk = idRolFk;
    }

    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    public List<Mensaje> getMensajeList1() {
        return mensajeList1;
    }

    public void setMensajeList1(List<Mensaje> mensajeList1) {
        this.mensajeList1 = mensajeList1;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<Archivo> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<Archivo> archivoList) {
        this.archivoList = archivoList;
    }

    public List<CursoAperturado> getCursoAperturadoList() {
        return cursoAperturadoList;
    }

    public void setCursoAperturadoList(List<CursoAperturado> cursoAperturadoList) {
        this.cursoAperturadoList = cursoAperturadoList;
    }
    
    public String getNombreCompleto(){
    	return "HOLA";
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioPk != null ? idUsuarioPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuarioPk == null && other.idUsuarioPk != null) || (this.idUsuarioPk != null && !this.idUsuarioPk.equals(other.idUsuarioPk))) {
            return false;
        }
        return true;
    }    
}
