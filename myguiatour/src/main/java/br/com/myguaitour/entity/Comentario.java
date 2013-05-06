/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguaitour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "comentario", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentario.findByDataComentario", query = "SELECT c FROM Comentario c WHERE c.dataComentario = :dataComentario"),
    @NamedQuery(name = "Comentario.findByComentarioUsuario", query = "SELECT c FROM Comentario c WHERE c.comentarioUsuario = :comentarioUsuario"),
    @NamedQuery(name = "Comentario.findByIdGuia", query = "SELECT c FROM Comentario c WHERE c.idGuia = :idGuia"),
    @NamedQuery(name = "Comentario.findByIdPonto", query = "SELECT c FROM Comentario c WHERE c.idPonto = :idPonto"),
    @NamedQuery(name = "Comentario.findByIdUsuario", query = "SELECT c FROM Comentario c WHERE c.idUsuario = :idUsuario")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario", nullable = false)
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_comentario", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComentario;
    @Size(max = 300)
    @Column(name = "comentario_usuario", length = 300)
    private String comentarioUsuario;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_ponto")
    private Integer idPonto;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Integer idComentario, Date dataComentario) {
        this.idComentario = idComentario;
        this.dataComentario = dataComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }

    public String getComentarioUsuario() {
        return comentarioUsuario;
    }

    public void setComentarioUsuario(String comentarioUsuario) {
        this.comentarioUsuario = comentarioUsuario;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
