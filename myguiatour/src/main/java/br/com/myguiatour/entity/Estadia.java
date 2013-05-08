/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.entity;

import java.util.Calendar;
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
@Table(name = "estadia", catalog = "guiatourdb", schema = "")
@PrimaryKeyJoinColumn(name = "ID_PONTO",
        referencedColumnName = "id_ponto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadia.findAll", query = "SELECT e FROM Estadia e"),
    @NamedQuery(name = "Estadia.findByFotoEstadia", query = "SELECT e FROM Estadia e WHERE e.fotoEstadia = :fotoEstadia"),
    @NamedQuery(name = "Estadia.findByQualidade", query = "SELECT e FROM Estadia e WHERE e.qualidade = :qualidade"),
    @NamedQuery(name = "Estadia.findByCategoria", query = "SELECT e FROM Estadia e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Estadia.findByIdPonto", query = "SELECT e FROM Estadia e WHERE e.idPonto = :idPonto")})
public class Estadia extends Pontoturistico {

    @Size(max = 20)
    @Column(name = "foto_estadia")
    private String fotoEstadia;
    @Size(max = 20)
    @Column(name = "qualidade")
    private String qualidade;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;

    public Estadia() {
    }

    public String getFotoEstadia() {
        return fotoEstadia;
    }

    public void setFotoEstadia(String fotoEstadia) {
        this.fotoEstadia = fotoEstadia;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
