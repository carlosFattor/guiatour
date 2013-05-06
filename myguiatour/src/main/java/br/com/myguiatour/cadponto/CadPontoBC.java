/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.cadponto;

import br.com.myguiatour.dao.HibernateDAO;
import br.com.myguiatour.dao.InterfaceDAO;
import br.com.myguiatour.entity.Guia;
import br.com.myguiatour.entity.Pontoturistico;
import br.com.myguiatour.util.FacesContextUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.map.MapModel;

/**
 *
 * @author Carlos
 */
public class CadPontoBC {
    @ManagedProperty(value = "#{listaGuias}")
    private List<Guia> listaGuias;
    @ManagedProperty(value = "#{pontoTur}")
    private List<Pontoturistico> pontoTur;
    private Guia guiaAtual;
    private boolean multGuia = false;
    private HibernateDAO cadPontos;
    private MapModel simpleModel;
    private String centerCity;

    private InterfaceDAO<Guia> guiaDAO(){
        InterfaceDAO<Guia> guiaDAO = new HibernateDAO<Guia>(Guia.class, FacesContextUtil.getRequestSession());
        return guiaDAO;
    }
    private InterfaceDAO<Pontoturistico> pontoDAO(){
        InterfaceDAO<Pontoturistico> pontoDAO = new HibernateDAO<Pontoturistico>(Pontoturistico.class, FacesContextUtil.getRequestSession());
        return pontoDAO;
    }
    
    public boolean pesqGuia(String nomePesq) {
        listaGuias = guiaDAO().getEntitys(nomePesq,"Guia.findByNomeGuia", "nomeGuia");
        if (listaGuias.size() > 0) {
            this.findPoint();
            if (listaGuias.size() <= 1) {
                guiaAtual = listaGuias.get(0);
            } else {
                multGuia = true;
            }
            return false;
        } else {
            return true;
        }
    }

    private void findPoint() {
        for (Guia guia : listaGuias) {
            pontoTur = (List<Pontoturistico>)pontoDAO().getEntity(guia.getIdGuia());
        }
    }
    
    Guia getGuiaAtual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Pontoturistico> getPontoTur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    MapModel addMarkers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getCenterCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Guia> getListaGuias() {
        return listaGuias;
    }

    public void setListaGuias(List<Guia> listaGuias) {
        this.listaGuias = listaGuias;
    }

    public boolean isMultGuia() {
        return multGuia;
    }

    public void setMultGuia(boolean multGuia) {
        this.multGuia = multGuia;
    }

    public HibernateDAO getCadPontos() {
        return cadPontos;
    }

    public void setCadPontos(HibernateDAO cadPontos) {
        this.cadPontos = cadPontos;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }
    
}
