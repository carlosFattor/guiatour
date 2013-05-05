/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "pontoturistico", catalog = "guiatourdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"latlng_ponto"})})
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontoturistico.findAll", query = "SELECT p FROM Pontoturistico p"),
    @NamedQuery(name = "Pontoturistico.findByIdPonto", query = "SELECT p FROM Pontoturistico p WHERE p.idPonto = :idPonto"),
    @NamedQuery(name = "Pontoturistico.findByNomePonto", query = "SELECT p FROM Pontoturistico p WHERE p.nomePonto = :nomePonto"),
    @NamedQuery(name = "Pontoturistico.findByFotoPonto1", query = "SELECT p FROM Pontoturistico p WHERE p.fotoPonto1 = :fotoPonto1"),
    @NamedQuery(name = "Pontoturistico.findByFotoPonto2", query = "SELECT p FROM Pontoturistico p WHERE p.fotoPonto2 = :fotoPonto2"),
    @NamedQuery(name = "Pontoturistico.findByFotoPonto3", query = "SELECT p FROM Pontoturistico p WHERE p.fotoPonto3 = :fotoPonto3"),
    @NamedQuery(name = "Pontoturistico.findByInfoPonto", query = "SELECT p FROM Pontoturistico p WHERE p.infoPonto = :infoPonto"),
    @NamedQuery(name = "Pontoturistico.findByComentarioPonto", query = "SELECT p FROM Pontoturistico p WHERE p.comentarioPonto = :comentarioPonto"),
    @NamedQuery(name = "Pontoturistico.findByUrlPonto", query = "SELECT p FROM Pontoturistico p WHERE p.urlPonto = :urlPonto"),
    @NamedQuery(name = "Pontoturistico.findByDataCadPonto", query = "SELECT p FROM Pontoturistico p WHERE p.dataCadPonto = :dataCadPonto"),
    @NamedQuery(name = "Pontoturistico.findByLatlngPonto", query = "SELECT p FROM Pontoturistico p WHERE p.latlngPonto = :latlngPonto"),
    @NamedQuery(name = "Pontoturistico.findByIdGuia", query = "SELECT p FROM Pontoturistico p WHERE p.idGuia = :idGuia"),
    @NamedQuery(name = "Pontoturistico.findByIdUsuario", query = "SELECT p FROM Pontoturistico p WHERE p.idUsuario = :idUsuario")})

public abstract class Pontoturistico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ponto", nullable = false)
    private Integer idPonto;
    @Size(max = 20)
    @Column(name = "nome_ponto", length = 20)
    private String nomePonto;
    @Size(max = 20)
    @Column(name = "foto_ponto1", length = 20)
    private String fotoPonto1;
    @Size(max = 20)
    @Column(name = "foto_ponto2", length = 20)
    private String fotoPonto2;
    @Size(max = 20)
    @Column(name = "foto_ponto3", length = 20)
    private String fotoPonto3;
    @Size(max = 100)
    @Column(name = "info_ponto", length = 100)
    private String infoPonto;
    @Size(max = 200)
    @Column(name = "comentario_ponto", length = 200)
    private String comentarioPonto;
    @Size(max = 100)
    @Column(name = "url_ponto", length = 100)
    private String urlPonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cad_ponto", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadPonto;
    @Size(max = 60)
    @Column(name = "latlng_ponto", length = 60)
    private String latlngPonto;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Transient
    private Integer classificacao;

    public Pontoturistico() {
    }

    public Pontoturistico(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public Pontoturistico(Integer idPonto, Date dataCadPonto) {
        this.idPonto = idPonto;
        this.dataCadPonto = dataCadPonto;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    public String getNomePonto() {
        return nomePonto;
    }

    public void setNomePonto(String nomePonto) {
        this.nomePonto = nomePonto;
    }

    public String getFotoPonto1() {
        return fotoPonto1;
    }

    public void setFotoPonto1(String fotoPonto1) {
        this.fotoPonto1 = fotoPonto1;
    }

    public String getFotoPonto2() {
        return fotoPonto2;
    }

    public void setFotoPonto2(String fotoPonto2) {
        this.fotoPonto2 = fotoPonto2;
    }

    public String getFotoPonto3() {
        return fotoPonto3;
    }

    public void setFotoPonto3(String fotoPonto3) {
        this.fotoPonto3 = fotoPonto3;
    }

    public String getInfoPonto() {
        return infoPonto;
    }

    public void setInfoPonto(String infoPonto) {
        this.infoPonto = infoPonto;
    }

    public String getComentarioPonto() {
        return comentarioPonto;
    }

    public void setComentarioPonto(String comentarioPonto) {
        this.comentarioPonto = comentarioPonto;
    }

    public String getUrlPonto() {
        return urlPonto;
    }

    public void setUrlPonto(String urlPonto) {
        this.urlPonto = urlPonto;
    }

    public Date getDataCadPonto() {
        return dataCadPonto;
    }

    public void setDataCadPonto(Date dataCadPonto) {
        this.dataCadPonto = dataCadPonto;
    }

    public String getLatlngPonto() {
        return latlngPonto;
    }

    public void setLatlngPonto(String latlngPonto) {
        this.latlngPonto = latlngPonto;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPonto != null ? idPonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontoturistico)) {
            return false;
        }
        Pontoturistico other = (Pontoturistico) object;
        if ((this.idPonto == null && other.idPonto != null) || (this.idPonto != null && !this.idPonto.equals(other.idPonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.guiatour.entity.Pontoturistico[ idPonto=" + idPonto + " ]";
    }

    /**
     * @return the classificacao
     */
    public Integer getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }
}
