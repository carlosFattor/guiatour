/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

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
    @Column(name = "id_usuario", nullable = false)
    private Long IdUsuario;
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;
    @Column(name="senha", nullable = false, length = 15)
    private String senha;   
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "data_nasc")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNasc;
    @Column(name="sexo", nullable = false, length = 1)
    private String sexo;           
    @Column(name="estado", nullable = false)
    private Integer estado;
    @Column(name="cidade")
    private Integer cidade;   
    @Column(name="foto")
    private String foto;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="FkPais")
    private Pais pais;
    
    @ManyToMany
    private List<Guia> guias;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Guia> getGuias() {
        return guias;
    }

    public void setGuias(List<Guia> guias) {
        this.guias = guias;
    }
    
    public Usuario() {
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getCidade() {
        return cidade;
    }

    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }
    @Column(name="status", nullable = false)
    private Boolean status;
    @Column(name = "data_cad")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCad;
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.IdUsuario != null ? this.IdUsuario.hashCode() : 0);
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
        if (this.IdUsuario != other.IdUsuario && (this.IdUsuario == null || !this.IdUsuario.equals(other.IdUsuario))) {
            return false;
        }
        return true;
    }
}
