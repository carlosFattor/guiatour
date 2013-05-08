/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
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
@PrimaryKeyJoinColumn(name = "ID_PONTO",
        referencedColumnName = "id_ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreterimento.findAll", query = "SELECT e FROM Entreterimento e"),
    @NamedQuery(name = "Entreterimento.findByFotoEntreterimento", query = "SELECT e FROM Entreterimento e WHERE e.fotoEntreterimento = :fotoEntreterimento"),
    @NamedQuery(name = "Entreterimento.findByCategoria", query = "SELECT e FROM Entreterimento e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Entreterimento.findByHorarioInicio", query = "SELECT e FROM Entreterimento e WHERE e.horarioInicio = :horarioInicio"),
    @NamedQuery(name = "Entreterimento.findByHorarioFim", query = "SELECT e FROM Entreterimento e WHERE e.horarioFim = :horarioFim"),
    @NamedQuery(name = "Entreterimento.findByAtracao", query = "SELECT e FROM Entreterimento e WHERE e.atracao = :atracao"),
    @NamedQuery(name = "Entreterimento.findByPeriodoInicio", query = "SELECT e FROM Entreterimento e WHERE e.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "Entreterimento.findByPeriodoFim", query = "SELECT e FROM Entreterimento e WHERE e.periodoFim = :periodoFim"),
    @NamedQuery(name = "Entreterimento.findByIdPonto", query = "SELECT e FROM Entreterimento e WHERE e.idPonto = :idPonto")})
public class Entreterimento extends Pontoturistico {

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

    public Entreterimento() {
    }

    public Entreterimento(Integer idEntreterimento) {
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
}
