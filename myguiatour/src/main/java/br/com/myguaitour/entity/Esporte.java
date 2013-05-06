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
@Table(name = "esporte", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esporte.findAll", query = "SELECT e FROM Esporte e"),
    @NamedQuery(name = "Esporte.findByIdEsporte", query = "SELECT e FROM Esporte e WHERE e.idEsporte = :idEsporte"),
    @NamedQuery(name = "Esporte.findByFotoEsporte", query = "SELECT e FROM Esporte e WHERE e.fotoEsporte = :fotoEsporte"),
    @NamedQuery(name = "Esporte.findByCategoria", query = "SELECT e FROM Esporte e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Esporte.findByInstrutor", query = "SELECT e FROM Esporte e WHERE e.instrutor = :instrutor"),
    @NamedQuery(name = "Esporte.findByCustoMedio", query = "SELECT e FROM Esporte e WHERE e.custoMedio = :custoMedio"),
    @NamedQuery(name = "Esporte.findByIdPonto", query = "SELECT e FROM Esporte e WHERE e.idPonto = :idPonto")})
public class Esporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_esporte")
    private Integer idEsporte;
    @Size(max = 20)
    @Column(name = "foto_esporte")
    private String fotoEsporte;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 100)
    @Column(name = "instrutor")
    private String instrutor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public Esporte() {
    }

    public Esporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }

    public Integer getIdEsporte() {
        return idEsporte;
    }

    public void setIdEsporte(Integer idEsporte) {
        this.idEsporte = idEsporte;
    }

    public String getFotoEsporte() {
        return fotoEsporte;
    }

    public void setFotoEsporte(String fotoEsporte) {
        this.fotoEsporte = fotoEsporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
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
        hash += (idEsporte != null ? idEsporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esporte)) {
            return false;
        }
        Esporte other = (Esporte) object;
        if ((this.idEsporte == null && other.idEsporte != null) || (this.idEsporte != null && !this.idEsporte.equals(other.idEsporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Esporte[ idEsporte=" + idEsporte + " ]";
    }
    
}
