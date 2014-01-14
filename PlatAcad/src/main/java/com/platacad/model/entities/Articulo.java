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
import javax.persistence.EntityListeners;
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
import javax.persistence.Transient;

import com.platacad.model.commons.UserInfo;

/**
 *
 * @author allen
 */
@Entity
@EntityListeners(AuditLogger.class)
@Table(name = "articulo", catalog = "platacad", schema = "")
public class Articulo implements Serializable, Auditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo_pk", nullable = false)
    private Integer idArticuloPk;
    
    @Column(name = "titulo", length = 255)
    private String titulo;
    
    @Lob
    @Column(name = "contenido")
    private byte[] contenido;
           
    @Embedded
    private Auditoria auditoria = new Auditoria();
    
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    
    @JoinColumn(name = "id_curso_aperturado_fk", referencedColumnName = "id_curso_aperturado_pk", nullable = false)
    @ManyToOne(optional = false)
    private CursoAperturado idCursoAperturadoFk;
    
    @JoinColumn(name = "id_archivo_fk", referencedColumnName = "id_archivo_pk")
    @ManyToOne
    private Archivo idArchivoFk;
    
    @OneToMany(mappedBy = "idArticuloFk")
    private List<Comentario> comentarioList;

    @Column(name = "estado_param")
    private Integer estado;
    
    @Transient
    private String contenidoValue;
    
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
    
    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public CursoAperturado getIdCursoAperturadoFk() {
        return idCursoAperturadoFk;
    }

    public void setIdCursoAperturadoFk(CursoAperturado idCursoAperturadoFk) {
        this.idCursoAperturadoFk = idCursoAperturadoFk;
    }

    public Archivo getIdArchivoFk() {
        return idArchivoFk;
    }

    public void setIdArchivoFk(Archivo idArchivoFk) {
        this.idArchivoFk = idArchivoFk;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public void prePresist() {
		auditoria.prePresist();
	}

	public void preUpdate() {
		auditoria.preUpdate();
	}

	public String getContenidoValue() {
		return contenidoValue;
	}

	public void setContenidoValue(String contenidoValue) {
		this.contenidoValue = contenidoValue;
	}
    
}
