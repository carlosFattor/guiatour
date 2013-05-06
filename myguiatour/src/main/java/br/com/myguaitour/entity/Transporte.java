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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "transporte", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte"),
    @NamedQuery(name = "Transporte.findByFotoTransporte", query = "SELECT t FROM Transporte t WHERE t.fotoTransporte = :fotoTransporte"),
    @NamedQuery(name = "Transporte.findByCategoria", query = "SELECT t FROM Transporte t WHERE t.categoria = :categoria"),
    @NamedQuery(name = "Transporte.findByCustoMedio", query = "SELECT t FROM Transporte t WHERE t.custoMedio = :custoMedio"),
    @NamedQuery(name = "Transporte.findByIdPonto", query = "SELECT t FROM Transporte t WHERE t.idPonto = :idPonto")})
public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transporte")
    private Integer idTransporte;
    @Size(max = 20)
    @Column(name = "foto_transporte")
    private String fotoTransporte;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getFotoTransporte() {
        return fotoTransporte;
    }

    public void setFotoTransporte(String fotoTransporte) {
        this.fotoTransporte = fotoTransporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(Float custoMedio) {
        this.custoMedio = custoMedio;
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
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
