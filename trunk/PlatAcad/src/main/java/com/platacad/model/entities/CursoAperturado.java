/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author allen
 */
/**
 * @author Allen
 *
 */
@Entity
@Table(name = "curso_aperturado", catalog = "platacad", schema = "")
public class CursoAperturado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_aperturado_pk", nullable = false)
    private Integer idCursoAperturado;
    
    @Embedded
    private Auditoria auditoria;
    
    @JoinColumn(name = "id_docente_fk", referencedColumnName = "id_usuario_pk", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idDocenteFk;
    
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso_pk", nullable = false)
    @ManyToOne(optional = false)
    private Curso idCursoFk;
    
    @Column(name = "id_ciclo_fk")
    private Integer idCicloFk;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<Articulo> articuloList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<TrabajoEncargado> trabajoEncargadoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<Examen> examenList;   
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoAperturadoFk")
    private List<Matricula> matriculaList;
    
    @Transient
    private String docenteValue;
        
    @Transient
    private Integer totalAlumnos;
    
    @Transient
    private Integer totalArticulos;
    
    @Transient
    private Integer totalExamenes;
    
    @Transient
    private Integer totalTrabajos;
    
    public CursoAperturado() {
    }

    public CursoAperturado(Integer idCursoAperturado) {
        this.idCursoAperturado = idCursoAperturado;
    }

    public Integer getIdCursoAperturado() {
        return idCursoAperturado;
    }

    public void setIdCursoAperturado(Integer idCursoAperturado) {
        this.idCursoAperturado = idCursoAperturado;
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
 
    public Integer getIdCicloFk() {
		return idCicloFk;
	}

	public void setIdCicloFk(Integer idCicloFk) {
		this.idCicloFk = idCicloFk;
	}

	public List<Matricula> getMatriculaList() {
		return matriculaList;
	}

	public void setMatriculaList(List<Matricula> matriculaList) {
		this.matriculaList = matriculaList;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDocenteValue() {
		return docenteValue;
	}

	public void setDocenteValue(String docenteValue) {
		this.docenteValue = docenteValue;
	}

	public Integer getTotalAlumnos() {
		return totalAlumnos;
	}

	public void setTotalAlumnos(Integer totalAlumnos) {
		this.totalAlumnos = totalAlumnos;
	}

	public Integer getTotalArticulos() {
		return totalArticulos;
	}

	public void setTotalArticulos(Integer totalArticulos) {
		this.totalArticulos = totalArticulos;
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
