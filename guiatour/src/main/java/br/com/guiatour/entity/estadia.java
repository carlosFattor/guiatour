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
public class estadia implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "foto_estadia")
    private String fotoestadia;
    @Column(name = "qualidade")
    private String qualidade;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public estadia() {
    }

    public String getFotoestadia() {
        return fotoestadia;
    }

    public void setFotoestadia(String fotoestadia) {
        this.fotoestadia = fotoestadia;
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
        int hash = 5;
        hash = 71 * hash + (this.fotoestadia != null ? this.fotoestadia.hashCode() : 0);
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
        final estadia other = (estadia) obj;
        if ((this.fotoestadia == null) ? (other.fotoestadia != null) : !this.fotoestadia.equals(other.fotoestadia)) {
            return false;
        }
        return true;
    }    
}
