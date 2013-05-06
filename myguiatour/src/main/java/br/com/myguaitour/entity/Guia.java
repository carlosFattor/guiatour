/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguaitour.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "guia", catalog = "guiatourdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"latlng_guia"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g"),
    @NamedQuery(name = "Guia.findByIdGuia", query = "SELECT g FROM Guia g WHERE g.idGuia = :idGuia"),
    @NamedQuery(name = "Guia.findByNomeGuia", query = "SELECT g FROM Guia g WHERE g.nomeGuia = :nomeGuia"),
    @NamedQuery(name = "Guia.findByEstado", query = "SELECT g FROM Guia g WHERE g.estado = :estado"),
    @NamedQuery(name = "Guia.findByPais", query = "SELECT g FROM Guia g WHERE g.pais = :pais"),
    @NamedQuery(name = "Guia.findByFoto1", query = "SELECT g FROM Guia g WHERE g.foto1 = :foto1"),
    @NamedQuery(name = "Guia.findByFoto2", query = "SELECT g FROM Guia g WHERE g.foto2 = :foto2"),
    @NamedQuery(name = "Guia.findByInfoGuia", query = "SELECT g FROM Guia g WHERE g.infoGuia = :infoGuia"),
    @NamedQuery(name = "Guia.findByComentarioGuia", query = "SELECT g FROM Guia g WHERE g.comentarioGuia = :comentarioGuia"),
    @NamedQuery(name = "Guia.findByLatlngGuia", query = "SELECT g FROM Guia g WHERE g.latlngGuia = :latlngGuia"),
    @NamedQuery(name = "Guia.findByUrlPonto", query = "SELECT g FROM Guia g WHERE g.urlPonto = :urlPonto"),
    @NamedQuery(name = "Guia.findByDtaqGuia", query = "SELECT g FROM Guia g WHERE g.dtaqGuia = :dtaqGuia"),
    @NamedQuery(name = "Guia.findByIdUsuario", query = "SELECT g FROM Guia g WHERE g.idUsuario = :idUsuario")})
public class Guia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia", nullable = false)
    private Integer idGuia;
    @Size(max = 20)
    @Column(name = "nome_guia", length = 20)
    private String nomeGuia;
    @Size(max = 20)
    @Column(name = "estado", length = 20)
    private String estado;
    @Size(max = 20)
    @Column(name = "pais", length = 20)
    private String pais;
    @Size(max = 20)
    @Column(name = "foto1", length = 20)
    private String foto1;
    @Size(max = 20)
    @Column(name = "foto2", length = 20)
    private String foto2;
    @Size(max = 100)
    @Column(name = "info_guia", length = 100)
    private String infoGuia;
    @Size(max = 300)
    @Column(name = "comentario_guia", length = 300)
    private String comentarioGuia;
    @Size(max = 60)
    @Column(name = "latlng_guia", length = 60)
    private String latlngGuia;
    @Size(max = 100)
    @Column(name = "url_ponto", length = 100)
    private String urlPonto;
    @Column(name = "dtaqGuia")
    private Integer dtaqGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Guia() {
    }

    public Guia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public String getNomeGuia() {
        return nomeGuia;
    }

    public void setNomeGuia(String nomeGuia) {
        this.nomeGuia = nomeGuia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getInfoGuia() {
        return infoGuia;
    }

    public void setInfoGuia(String infoGuia) {
        this.infoGuia = infoGuia;
    }

    public String getComentarioGuia() {
        return comentarioGuia;
    }

    public void setComentarioGuia(String comentarioGuia) {
        this.comentarioGuia = comentarioGuia;
    }

    public String getLatlngGuia() {
        return latlngGuia;
    }

    public void setLatlngGuia(String latlngGuia) {
        this.latlngGuia = latlngGuia;
    }

    public String getUrlPonto() {
        return urlPonto;
    }

    public void setUrlPonto(String urlPonto) {
        this.urlPonto = urlPonto;
    }

    public Integer getDtaqGuia() {
        return dtaqGuia;
    }

    public void setDtaqGuia(Integer dtaqGuia) {
        this.dtaqGuia = dtaqGuia;
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
        hash += (idGuia != null ? idGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idGuia == null && other.idGuia != null) || (this.idGuia != null && !this.idGuia.equals(other.idGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Guia[ idGuia=" + idGuia + " ]";
    }
    
}
