/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "excluir", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Excluir.findAll", query = "SELECT e FROM Excluir e"),
    @NamedQuery(name = "Excluir.findByIdExclusao", query = "SELECT e FROM Excluir e WHERE e.idExclusao = :idExclusao"),
    @NamedQuery(name = "Excluir.findByDataExclusao", query = "SELECT e FROM Excluir e WHERE e.dataExclusao = :dataExclusao"),
    @NamedQuery(name = "Excluir.findByIdGuia", query = "SELECT e FROM Excluir e WHERE e.idGuia = :idGuia"),
    @NamedQuery(name = "Excluir.findByIdPonto", query = "SELECT e FROM Excluir e WHERE e.idPonto = :idPonto"),
    @NamedQuery(name = "Excluir.findByIdUsuario", query = "SELECT e FROM Excluir e WHERE e.idUsuario = :idUsuario")})
public class Excluir implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exclusao", nullable = false)
    private Integer idExclusao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_exclusao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExclusao;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_ponto")
    private Integer idPonto;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Excluir() {
    }

    public Excluir(Integer idExclusao) {
        this.idExclusao = idExclusao;
    }

    public Excluir(Integer idExclusao, Date dataExclusao) {
        this.idExclusao = idExclusao;
        this.dataExclusao = dataExclusao;
    }

    public Integer getIdExclusao() {
        return idExclusao;
    }

    public void setIdExclusao(Integer idExclusao) {
        this.idExclusao = idExclusao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
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
        hash += (idExclusao != null ? idExclusao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Excluir)) {
            return false;
        }
        Excluir other = (Excluir) object;
        if ((this.idExclusao == null && other.idExclusao != null) || (this.idExclusao != null && !this.idExclusao.equals(other.idExclusao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Excluir[ idExclusao=" + idExclusao + " ]";
    }
    
}
