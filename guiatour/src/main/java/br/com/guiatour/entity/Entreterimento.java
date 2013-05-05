/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
@Table
public class Entreterimento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "foto_entreterimento")
    private String fotoEntreterimento;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "horario_inicio")
    @Temporal(TemporalType.TIME)
    private Date horarioInicio;
    @Column(name = "horario_fim")
    @Temporal(TemporalType.TIME)
    private Date horarioFim;
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
        int hash = 7;
        hash = 97 * hash + (this.fotoEntreterimento != null ? this.fotoEntreterimento.hashCode() : 0);
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
        final Entreterimento other = (Entreterimento) obj;
        if ((this.fotoEntreterimento == null) ? (other.fotoEntreterimento != null) : !this.fotoEntreterimento.equals(other.fotoEntreterimento)) {
            return false;
        }
        return true;
    }    
}
