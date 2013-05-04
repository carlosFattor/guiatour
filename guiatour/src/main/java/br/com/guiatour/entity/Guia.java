/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Carlos
 */
public class Guia {
 
    private String nomeGuia;
    private String nomeFoto1;
    private String nomeFoto2;
    private String infoFoto;
    private String comentFoto;
    private double latlng;
    private String url;
    
    
    
    @ManyToOne(optional = false)
    @ForeignKey(name="FkPais")
    private Pais pais;
    
    @ManyToMany(mappedBy = "guias")
    private List<Usuario> usuarios;
}
