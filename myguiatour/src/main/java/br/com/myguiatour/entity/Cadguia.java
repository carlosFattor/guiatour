/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "cadguia", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadguia.findAll", query = "SELECT c FROM Cadguia c"),
    @NamedQuery(name = "Cadguia.findByIdCadGuia", query = "SELECT c FROM Cadguia c WHERE c.idCadGuia = :idCadGuia"),
    @NamedQuery(name = "Cadguia.findByDatacadGuia", query = "SELECT c FROM Cadguia c WHERE c.datacadGuia = :datacadGuia"),
    @NamedQuery(name = "Cadguia.findByIdGuia", query = "SELECT c FROM Cadguia c WHERE c.idGuia = :idGuia"),
    @NamedQuery(name = "Cadguia.findByIdUsuario", query = "SELECT c FROM Cadguia c WHERE c.idUsuario = :idUsuario")})
public class Cadguia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cad_guia")
    private Integer idCadGuia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadGuia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadGuia;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Cadguia() {
    }

    public Cadguia(Integer idCadGuia) {
        this.idCadGuia = idCadGuia;
    }

    public Cadguia(Integer idCadGuia, Date datacadGuia) {
        this.idCadGuia = idCadGuia;
        this.datacadGuia = datacadGuia;
    }

    public Integer getIdCadGuia() {
        return idCadGuia;
    }

    public void setIdCadGuia(Integer idCadGuia) {
        this.idCadGuia = idCadGuia;
    }

    public Date getDatacadGuia() {
        return datacadGuia;
    }

    public void setDatacadGuia(Date datacadGuia) {
        this.datacadGuia = datacadGuia;
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
        hash += (idCadGuia != null ? idCadGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadguia)) {
            return false;
        }
        Cadguia other = (Cadguia) object;
        if ((this.idCadGuia == null && other.idCadGuia != null) || (this.idCadGuia != null && !this.idCadGuia.equals(other.idCadGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Cadguia[ idCadGuia=" + idCadGuia + " ]";
    }
    
}
