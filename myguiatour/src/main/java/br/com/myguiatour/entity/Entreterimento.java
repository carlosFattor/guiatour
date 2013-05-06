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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "entreterimento", catalog = "guiatourdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreterimento.findAll", query = "SELECT e FROM Entreterimento e"),
    @NamedQuery(name = "Entreterimento.findByIdEntreterimento", query = "SELECT e FROM Entreterimento e WHERE e.idEntreterimento = :idEntreterimento"),
    @NamedQuery(name = "Entreterimento.findByFotoEntreterimento", query = "SELECT e FROM Entreterimento e WHERE e.fotoEntreterimento = :fotoEntreterimento"),
    @NamedQuery(name = "Entreterimento.findByCategoria", query = "SELECT e FROM Entreterimento e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Entreterimento.findByHorarioInicio", query = "SELECT e FROM Entreterimento e WHERE e.horarioInicio = :horarioInicio"),
    @NamedQuery(name = "Entreterimento.findByHorarioFim", query = "SELECT e FROM Entreterimento e WHERE e.horarioFim = :horarioFim"),
    @NamedQuery(name = "Entreterimento.findByAtracao", query = "SELECT e FROM Entreterimento e WHERE e.atracao = :atracao"),
    @NamedQuery(name = "Entreterimento.findByPeriodoInicio", query = "SELECT e FROM Entreterimento e WHERE e.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "Entreterimento.findByPeriodoFim", query = "SELECT e FROM Entreterimento e WHERE e.periodoFim = :periodoFim"),
    @NamedQuery(name = "Entreterimento.findByIdPonto", query = "SELECT e FROM Entreterimento e WHERE e.idPonto = :idPonto")})
public class Entreterimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entreterimento")
    private Integer idEntreterimento;
    @Size(max = 20)
    @Column(name = "foto_entreterimento")
    private String fotoEntreterimento;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "horario_inicio")
    @Temporal(TemporalType.TIME)
    private Date horarioInicio;
    @Column(name = "horario_fim")
    @Temporal(TemporalType.TIME)
    private Date horarioFim;
    @Size(max = 200)
    @Column(name = "atracao")
    private String atracao;
    @Column(name = "periodo_inicio")
    @Temporal(TemporalType.DATE)
    private Date periodoInicio;
    @Column(name = "periodo_fim")
    @Temporal(TemporalType.DATE)
    private Date periodoFim;
    @Column(name = "id_ponto")
    private Integer idPonto;

    public Entreterimento() {
    }

    public Entreterimento(Integer idEntreterimento) {
        this.idEntreterimento = idEntreterimento;
    }

    public Integer getIdEntreterimento() {
        return idEntreterimento;
    }

    public void setIdEntreterimento(Integer idEntreterimento) {
        this.idEntreterimento = idEntreterimento;
    }

    public String getFotoEntreterimento() {
        return fotoEntreterimento;
    }

    public void setFotoEntreterimento(String fotoEntreterimento) {
        this.fotoEntreterimento = fotoEntreterimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Date horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getAtracao() {
        return atracao;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public Date getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(Date periodoFim) {
        this.periodoFim = periodoFim;
    }

    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntreterimento != null ? idEntreterimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreterimento)) {
            return false;
        }
        Entreterimento other = (Entreterimento) object;
        if ((this.idEntreterimento == null && other.idEntreterimento != null) || (this.idEntreterimento != null && !this.idEntreterimento.equals(other.idEntreterimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.myguaitour.entity.Entreterimento[ idEntreterimento=" + idEntreterimento + " ]";
    }
    
}
