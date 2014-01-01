/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.platacad.helpers.KeyWords;
import com.platacad.to.UsuarioTO;

/**
 *
 * @author allen
 */
/**
 * @author Allen
 *
 */
@Entity
@Table(name = "usuario", catalog = "platacad", schema = "")
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
    
    @Embedded
    private Auditoria auditoria;
        
    @Column(name = "estado_param")
    private Integer estado;
    
    @Column(name = "rol_param")
    private Integer rol;    

    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Articulo> articuloList;
    
    @OneToMany(mappedBy = "idUsuarioDestinoFk")
    private List<Mensaje> mensajeList;
    
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Mensaje> mensajeList1;
    
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Comentario> comentarioList;
    
    @OneToMany(mappedBy = "idUsuarioFk")
    private List<Archivo> archivoList;
    
    @OneToMany(mappedBy = "idDocenteFk")
    private List<CursoAperturado> cursoAperturadoList;
    
    @Transient
    private String fullName;
    
    @Transient
    private Boolean isAlumno;
    
    @Transient
    private Boolean isDocente;
    
    @Transient
    private Boolean isAdministrativo;
    
    @Transient
    private Integer totalMensajes;
    
    @Transient
    private Integer totalExamenes;
    
    @Transient
    private Integer totalTrabajos;
    
    @PostLoad
    public void loadTrasients() {
    	StringBuffer buffer = new StringBuffer();
		buffer.append(nombres);
		buffer.append(KeyWords.BLANK_SPACE);
		buffer.append(apellidoPaterno);
		buffer.append(KeyWords.BLANK_SPACE);
		buffer.append(apellidoMaterno);
    	fullName = buffer.toString();
    }
    
    public Usuario() {
    }

    public Usuario(String idUsuarioPk) {
        this.idUsuarioPk = idUsuarioPk;
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

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}

	public String getFullName() {		
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getIsAlumno() {
		return isAlumno;
	}

	public void setIsAlumno(Boolean isAlumno) {
		this.isDocente = Boolean.FALSE;
		this.isAdministrativo = Boolean.FALSE;
		this.isAlumno = isAlumno;
	}

	public Boolean getIsDocente() {
		return isDocente;
	}

	public void setIsDocente(Boolean isDocente) {
		this.isAlumno = Boolean.FALSE;
		this.isAdministrativo = Boolean.FALSE;
		this.isDocente = isDocente;
	}

	public Boolean getIsAdministrativo() {
		return isAdministrativo;
	}

	public void setIsAdministrativo(Boolean isAdministrativo) {
		this.isAlumno = Boolean.FALSE;
		this.isDocente = Boolean.FALSE;
		this.isAdministrativo = isAdministrativo;
	}

	public Integer getTotalMensajes() {
		return totalMensajes;
	}

	public void setTotalMensajes(Integer totalMensajes) {
		this.totalMensajes = totalMensajes;
	}

	public Integer getTotalExamenes() {
		return totalExamenes;
	}

	public void setTotalExamenes(Integer totalExamenes) {
		this.totalExamenes = totalExamenes;
	}

	public Integer getTotalTrabajos() {
		return totalTrabajos;
	}

	public void setTotalTrabajos(Integer totalTrabajos) {
		this.totalTrabajos = totalTrabajos;
	}
    
}
