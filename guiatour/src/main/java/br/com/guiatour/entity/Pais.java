
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name="pais")
public class Pais implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPais;
    @Column(name="nome_pais", unique = true, nullable = false)
    private String nomePais;
    @Column(name="ddi")
    private Integer ddi;

    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name="FkPais")
    private List<Usuario> usuario;
    
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @ForeignKey(name="FkEstado")
    private List<Estado> estado;
    
    public Pais() {
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }    

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.idPais != null ? this.idPais.hashCode() : 0);
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
        final Pais other = (Pais) obj;
        if (this.idPais != other.idPais && (this.idPais == null || !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }
}
