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
@Table(name = "avaliaguia", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliaguia.findAll", query = "SELECT a FROM Avaliaguia a"),
    @NamedQuery(name = "Avaliaguia.findByIdAvaliaGuia", query = "SELECT a FROM Avaliaguia a WHERE a.idAvaliaGuia = :idAvaliaGuia"),
    @NamedQuery(name = "Avaliaguia.findByNota", query = "SELECT a FROM Avaliaguia a WHERE a.nota = :nota"),
    @NamedQuery(name = "Avaliaguia.findByIdGuia", query = "SELECT a FROM Avaliaguia a WHERE a.idGuia = :idGuia"),
    @NamedQuery(name = "Avaliaguia.findByIdUsuario", query = "SELECT a FROM Avaliaguia a WHERE a.idUsuario = :idUsuario")})
public class Avaliaguia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avalia_guia", nullable = false)
    private Integer idAvaliaGuia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 12)
    private Float nota;
    @Column(name = "id_guia")
    private Integer idGuia;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Avaliaguia() {
    }

    public Avaliaguia(Integer idAvaliaGuia) {
        this.idAvaliaGuia = idAvaliaGuia;
    }

    public Integer getIdAvaliaGuia() {
        return idAvaliaGuia;
    }

    public void setIdAvaliaGuia(Integer idAvaliaGuia) {
        this.idAvaliaGuia = idAvaliaGuia;
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
        hash += (idAvaliaGuia != null ? idAvaliaGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliaguia)) {
            return false;
        }
        Avaliaguia other = (Avaliaguia) object;
        if ((this.idAvaliaGuia == null && other.idAvaliaGuia != null) || (this.idAvaliaGuia != null && !this.idAvaliaGuia.equals(other.idAvaliaGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Avaliaguia[ idAvaliaGuia=" + idAvaliaGuia + " ]";
    }
    
}
