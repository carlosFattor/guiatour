/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{
    private static final long serialVersionURI = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idCidade;
    @Column(name="nome_cidade")
    private String nomeCidade;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="FkCidade")
    private Estado estado;

    public Cidade() {
    }

    public long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.idCidade ^ (this.idCidade >>> 32));
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
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade) {
            return false;
        }
        return true;
    }
    
}
