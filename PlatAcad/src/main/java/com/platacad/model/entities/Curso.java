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
import javax.persistence.Transient;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "curso", catalog = "platacad", schema = "")
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
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @Embedded
    private Auditoria auditoria;
    
    @OneToMany(mappedBy = "idCursoDestinoFk")
    private List<Mensaje> mensajeList;
    
    @Column(name = "tipo_param")
    private Integer tipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoFk")
    private List<CursoAperturado> cursoAperturadoList;
        
    @Transient
    private String tipoValue;

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

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }
    
    public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public String getTipoValue() {
		return tipoValue;
	}

	public void setTipoValue(String tipoValue) {
		this.tipoValue = tipoValue;
	}
    
}
