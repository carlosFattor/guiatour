/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "barerest", catalog = "guiatourdb", schema = "")
@PrimaryKeyJoinColumn(name="ID_PONTO",
        referencedColumnName = "id_ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barerest.findAll", query = "SELECT b FROM Barerest b"),
    @NamedQuery(name = "Barerest.findByIdBarRest", query = "SELECT b FROM Barerest b WHERE b.idBarRest = :idBarRest"),
    @NamedQuery(name = "Barerest.findByFotoBar", query = "SELECT b FROM Barerest b WHERE b.fotoBar = :fotoBar"),
    @NamedQuery(name = "Barerest.findByCategoria", query = "SELECT b FROM Barerest b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "Barerest.findByCustoMedio", query = "SELECT b FROM Barerest b WHERE b.custoMedio = :custoMedio"),
    @NamedQuery(name = "Barerest.findByIdPonto", query = "SELECT b FROM Barerest b WHERE b.idPonto = :idPonto")})
public class Barerest extends Pontoturistico{
    
    private Integer idBarRest;
    @Size(max = 20)
    @Column(name = "foto_bar")
    private String fotoBar;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;    

    public Barerest() {
    }

    public Barerest(Integer idBarRest) {
        this.idBarRest = idBarRest;
    }

    public Integer getIdBarRest() {
        return idBarRest;
    }

    public void setIdBarRest(Integer idBarRest) {
        this.idBarRest = idBarRest;
    }

    public String getFotoBar() {
        return fotoBar;
    }

    public void setFotoBar(String fotoBar) {
        this.fotoBar = fotoBar;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarRest != null ? idBarRest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barerest)) {
            return false;
        }
        Barerest other = (Barerest) object;
        if ((this.idBarRest == null && other.idBarRest != null) || (this.idBarRest != null && !this.idBarRest.equals(other.idBarRest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Barerest[ idBarRest=" + idBarRest + " ]";
    }
    
}
