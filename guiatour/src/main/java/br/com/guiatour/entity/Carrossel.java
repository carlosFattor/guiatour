/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos
 */
@ManagedBean
@RequestScoped
public class Carrossel {

    private List<Foto> fotos;
    int i = 0;

    /**
     * Creates a new instance of Carrossel
     */
    public Carrossel() {
        fotos = new ArrayList<Foto>();
        do {
            i++;
            Foto foto = new Foto();
            foto.setId(i);
            foto.setNome(i + ".jpg");
            foto.setTitle("titulo " + i);
            foto.setDescription("Descricao " + i);
            fotos.add(foto);
        } while (i < 10);
    }
}
