/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pessoa", nullable = false)
    private Long IdPessoa;
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "data_cad")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCad;
    @Column(name = "data_nasc")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNasc;

    public Usuario() {
    }

    public Long getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Long IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.IdPessoa != null ? this.IdPessoa.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.IdPessoa != other.IdPessoa && (this.IdPessoa == null || !this.IdPessoa.equals(other.IdPessoa))) {
            return false;
        }
        return true;
    }
}
