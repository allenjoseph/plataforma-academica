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
import javax.persistence.Lob;
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
@Table(name = "archivo", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
    @NamedQuery(name = "Archivo.findByIdArchivoPk", query = "SELECT a FROM Archivo a WHERE a.idArchivoPk = :idArchivoPk")})
public class Archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_archivo_pk", nullable = false)
    private Integer idArchivoPk;
    @Lob
    @Column(name = "contenido")
    private byte[] contenido;
    @OneToMany(mappedBy = "idArchivoFk")
    private List<Articulo> articuloList;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @OneToMany(mappedBy = "idArchivoFk")
    private List<Documento> documentoList;
    @OneToMany(mappedBy = "idArchivoFk")
    private List<DetalleTrabajo> detalleTrabajoList;

    public Archivo() {
    }

    public Archivo(Integer idArchivoPk) {
        this.idArchivoPk = idArchivoPk;
    }

    public Integer getIdArchivoPk() {
        return idArchivoPk;
    }

    public void setIdArchivoPk(Integer idArchivoPk) {
        this.idArchivoPk = idArchivoPk;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
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
        hash += (idArchivoPk != null ? idArchivoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idArchivoPk == null && other.idArchivoPk != null) || (this.idArchivoPk != null && !this.idArchivoPk.equals(other.idArchivoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Archivo[ idArchivoPk=" + idArchivoPk + " ]";
    }
    
}