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
public class esporte implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "foto_esporte")
    private String fotoEsporte;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "instrutor")
    private String instrutor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public esporte() {
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
        int hash = 3;
        hash = 31 * hash + (this.fotoEsporte != null ? this.fotoEsporte.hashCode() : 0);
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
        final esporte other = (esporte) obj;
        if ((this.fotoEsporte == null) ? (other.fotoEsporte != null) : !this.fotoEsporte.equals(other.fotoEsporte)) {
            return false;
        }
        return true;
    }  
}
