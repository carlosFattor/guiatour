/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table
public class transporte implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(name = "foto_transporte")
    private String fotoTransporte;
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;
    @Column(name = "id_ponto")
    private Integer idPonto;
    
    public transporte() {
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
        int hash = 3;
        hash = 17 * hash + (this.fotoTransporte != null ? this.fotoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final transporte other = (transporte) obj;
        if ((this.fotoTransporte == null) ? (other.fotoTransporte != null) : !this.fotoTransporte.equals(other.fotoTransporte)) {
            return false;
        }
        return true;
    }
    
}
