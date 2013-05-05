/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "download", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Download.findAll", query = "SELECT d FROM Download d"),
    @NamedQuery(name = "Download.findByIdDownload", query = "SELECT d FROM Download d WHERE d.idDownload = :idDownload"),
    @NamedQuery(name = "Download.findByQtdeDownload", query = "SELECT d FROM Download d WHERE d.qtdeDownload = :qtdeDownload"),
    @NamedQuery(name = "Download.findByIdGuia", query = "SELECT d FROM Download d WHERE d.idGuia = :idGuia"),
    @NamedQuery(name = "Download.findByIdUsuario", query = "SELECT d FROM Download d WHERE d.idUsuario = :idUsuario")})
public class Download implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_download", nullable = false)
    private Integer idDownload;
    @Column(name = "qtde_download")
    private Integer qtdeDownload;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Download() {
    }

    public Download(Integer idDownload) {
        this.idDownload = idDownload;
    }

    public Integer getIdDownload() {
        return idDownload;
    }

    public void setIdDownload(Integer idDownload) {
        this.idDownload = idDownload;
    }

    public Integer getQtdeDownload() {
        return qtdeDownload;
    }

    public void setQtdeDownload(Integer qtdeDownload) {
        this.qtdeDownload = qtdeDownload;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
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
        hash += (idDownload != null ? idDownload.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Download)) {
            return false;
        }
        Download other = (Download) object;
        if ((this.idDownload == null && other.idDownload != null) || (this.idDownload != null && !this.idDownload.equals(other.idDownload))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.guiatour.entity.Download[ idDownload=" + idDownload + " ]";
    }
    
}
