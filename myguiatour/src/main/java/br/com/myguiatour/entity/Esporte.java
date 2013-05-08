/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "esporte", catalog = "guiatourdb", schema = "")
@PrimaryKeyJoinColumn(name = "ID_PONTO",
        referencedColumnName = "id_ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esporte.findAll", query = "SELECT e FROM Esporte e"),
    @NamedQuery(name = "Esporte.findByFotoEsporte", query = "SELECT e FROM Esporte e WHERE e.fotoEsporte = :fotoEsporte"),
    @NamedQuery(name = "Esporte.findByCategoria", query = "SELECT e FROM Esporte e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Esporte.findByInstrutor", query = "SELECT e FROM Esporte e WHERE e.instrutor = :instrutor"),
    @NamedQuery(name = "Esporte.findByCustoMedio", query = "SELECT e FROM Esporte e WHERE e.custoMedio = :custoMedio"),
    @NamedQuery(name = "Esporte.findByIdPonto", query = "SELECT e FROM Esporte e WHERE e.idPonto = :idPonto")})
public class Esporte extends Pontoturistico {

    @Size(max = 20)
    @Column(name = "foto_esporte")
    private String fotoEsporte;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 100)
    @Column(name = "instrutor")
    private String instrutor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;

    public Esporte() {
    }

    public Esporte(Integer idEsporte) {
    }

    public String getFotoEsporte() {
        return fotoEsporte;
    }

    public void setFotoEsporte(String fotoEsporte) {
        this.fotoEsporte = fotoEsporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public Float getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(Float custoMedio) {
        this.custoMedio = custoMedio;
    }
}
