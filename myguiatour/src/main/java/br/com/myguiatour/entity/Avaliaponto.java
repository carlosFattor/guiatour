/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "avaliaponto", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliaponto.findAll", query = "SELECT a FROM Avaliaponto a"),
    @NamedQuery(name = "Avaliaponto.findByIdAvaliaPonto", query = "SELECT a FROM Avaliaponto a WHERE a.idAvaliaPonto = :idAvaliaPonto"),
    @NamedQuery(name = "Avaliaponto.findByNota", query = "SELECT a FROM Avaliaponto a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliaponto.findByIdGuia", query = "SELECT a FROM Avaliaponto a WHERE a.idGuia = :idGuia"),
    @NamedQuery(name = "Avaliaponto.findByIdUsuario", query = "SELECT a FROM Avaliaponto a WHERE a.idUsuario = :idUsuario"),
    @NamedQuery(name = "Avaliaponto.findByIdUsuarioIdGuia", query = "SELECT a FROM Avaliaponto a WHERE a.idUsuario = :idUsuario and a.idGuia = :idGuia")})
public class Avaliaponto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avalia_ponto", nullable = false)
    private Integer idAvaliaPonto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 12)
    private Float nota;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Avaliaponto() {
    }

    public Avaliaponto(Integer idAvaliaPonto) {
        this.idAvaliaPonto = idAvaliaPonto;
    }

    public Integer getIdAvaliaPonto() {
        return idAvaliaPonto;
    }

    public void setIdAvaliaPonto(Integer idAvaliaPonto) {
        this.idAvaliaPonto = idAvaliaPonto;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
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
        hash += (idAvaliaPonto != null ? idAvaliaPonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliaponto)) {
            return false;
        }
        Avaliaponto other = (Avaliaponto) object;
        if ((this.idAvaliaPonto == null && other.idAvaliaPonto != null) || (this.idAvaliaPonto != null && !this.idAvaliaPonto.equals(other.idAvaliaPonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Avaliaponto[ idAvaliaPonto=" + idAvaliaPonto + " ]";
    }
}
