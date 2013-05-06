/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "estadia", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadia.findAll", query = "SELECT e FROM Estadia e"),
    @NamedQuery(name = "Estadia.findByIdEstadia", query = "SELECT e FROM Estadia e WHERE e.idEstadia = :idEstadia"),
    @NamedQuery(name = "Estadia.findByFotoEstadia", query = "SELECT e FROM Estadia e WHERE e.fotoEstadia = :fotoEstadia"),
    @NamedQuery(name = "Estadia.findByQualidade", query = "SELECT e FROM Estadia e WHERE e.qualidade = :qualidade"),
    @NamedQuery(name = "Estadia.findByCategoria", query = "SELECT e FROM Estadia e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Estadia.findByIdPonto", query = "SELECT e FROM Estadia e WHERE e.idPonto = :idPonto")})
public class Estadia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadia")
    private Integer idEstadia;
    @Size(max = 20)
    @Column(name = "foto_estadia")
    private String fotoEstadia;
    @Size(max = 20)
    @Column(name = "qualidade")
    private String qualidade;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public Estadia() {
    }

    public Estadia(Integer idEstadia) {
        this.idEstadia = idEstadia;
    }

    public Integer getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(Integer idEstadia) {
        this.idEstadia = idEstadia;
    }

    public String getFotoEstadia() {
        return fotoEstadia;
    }

    public void setFotoEstadia(String fotoEstadia) {
        this.fotoEstadia = fotoEstadia;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadia != null ? idEstadia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadia)) {
            return false;
        }
        Estadia other = (Estadia) object;
        if ((this.idEstadia == null && other.idEstadia != null) || (this.idEstadia != null && !this.idEstadia.equals(other.idEstadia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Estadia[ idEstadia=" + idEstadia + " ]";
    }
    
}
