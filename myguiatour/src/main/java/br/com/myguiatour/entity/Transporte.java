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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "transporte", catalog = "guiatourdb", schema = "")
@PrimaryKeyJoinColumn(name = "ID_PONTO",
        referencedColumnName = "id_ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByFotoTransporte", query = "SELECT t FROM Transporte t WHERE t.fotoTransporte = :fotoTransporte"),
    @NamedQuery(name = "Transporte.findByCategoria", query = "SELECT t FROM Transporte t WHERE t.categoria = :categoria"),
    @NamedQuery(name = "Transporte.findByCustoMedio", query = "SELECT t FROM Transporte t WHERE t.custoMedio = :custoMedio"),
    @NamedQuery(name = "Transporte.findByIdPonto", query = "SELECT t FROM Transporte t WHERE t.idPonto = :idPonto")})
public class Transporte extends Pontoturistico{
    private static final long serialVersionUID = 1L;

    @Size(max = 20)
    @Column(name = "foto_transporte")
    private String fotoTransporte;
    @Size(max = 100)
    @Column(name = "categoria")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_medio")
    private Float custoMedio;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
    }

    public String getFotoTransporte() {
        return fotoTransporte;
    }

    public void setFotoTransporte(String fotoTransporte) {
        this.fotoTransporte = fotoTransporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(Float custoMedio) {
        this.custoMedio = custoMedio;
    }
}
