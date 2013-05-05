/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name="bar_rest")
@PrimaryKeyJoinColumn(name = "Ponto_ID_Ponto", referencedColumnName = "id_ponto")
public class BarRest extends Pontoturistico{
        
    @Column(name = "foto_bar", nullable = false, length = 80)
    private String fotoBar;
    @Column(name = "categoria")
    private String categoria;    
    @Column(name = "custo_medio")
    private Float custoMedio;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public BarRest() {
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

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.fotoBar != null ? this.fotoBar.hashCode() : 0);
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
        final BarRest other = (BarRest) obj;
        if ((this.fotoBar == null) ? (other.fotoBar != null) : !this.fotoBar.equals(other.fotoBar)) {
            return false;
        }
        return true;
    }
}
