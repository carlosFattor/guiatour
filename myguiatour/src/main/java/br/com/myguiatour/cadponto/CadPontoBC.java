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
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
    private MapModel advancedModel;

    private InterfaceDAO<Guia> guiaDAO() {
        InterfaceDAO<Guia> guiaDAO = new HibernateDAO<Guia>(Guia.class, FacesContextUtil.getRequestSession());
        return guiaDAO;
    }

    private InterfaceDAO<Pontoturistico> pontoDAO() {
        InterfaceDAO<Pontoturistico> pontoDAO = new HibernateDAO<Pontoturistico>(Pontoturistico.class, FacesContextUtil.getRequestSession());
        return pontoDAO;
    }

    public boolean pesqGuia(String nomePesq) {
        listaGuias = guiaDAO().getEntitys(nomePesq, "Guia.findByNomeGuia", "nomeGuia");
        this.setClassificacaoGuia();
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
            pontoTur = (List<Pontoturistico>) pontoDAO().getEntity(guia.getIdGuia());
        }
    }

    MapModel addMarkers() {
        simpleModel = new DefaultMapModel();
        MapModel map, map2;
        map = this.findMarkersGuia();
        map2 = this.findMarkersPonto();
        this.setaPontoOverllay(map, map2);


        return simpleModel;
    }

    private MapModel findMarkersGuia() {
        advancedModel = new DefaultMapModel();
        int i = 0;
        for (Guia guia : listaGuias) {
            String coord[] = guia.getLatlngGuia().split(",");

            LatLng latlng = new LatLng(Double.parseDouble(coord[0]), Double.parseDouble(coord[1]));
            Integer rating = Integer.parseInt(guia.getClassificacao().toString());

            listaGuias.get(i).setClassificacao(rating);
            i++;

            advancedModel.addOverlay(new Marker(latlng, guia.getNomeGuia(), guia));
        }
        return advancedModel;
    }

    private MapModel findMarkersPonto() {
        advancedModel = new DefaultMapModel();
        int i = 0;
        for (Pontoturistico ponto : pontoTur) {
            String coord[] = ponto.getLatlngPonto().split(",");

            LatLng latlng = new LatLng(Double.parseDouble(coord[0]), Double.parseDouble(coord[1]));

            Integer rating = Integer.parseInt(ponto.getClassificacao().toString());
            pontoTur.get(i).setClassificacao(rating);

            advancedModel.addOverlay(new Marker(latlng, ponto.getNomePonto(), ponto));

        }
        return advancedModel;
    }    

    void cadGuia(Guia guiaAtual) {
        
        try {
            guiaDAO().save(guiaAtual);            
            CadPontoBB.msg = new FacesMessage("Sucesso", guiaAtual.getNomeGuia() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", guiaAtual.getNomeGuia() + " não cadastrada");
        }
    }

    private void setaPontoOverllay(MapModel map, MapModel map2) {
        for (Marker marker : map.getMarkers()) {
            int i = 0;
            simpleModel.addOverlay(marker);
            if (i == 0) {
                this.formataLatLng(marker.getLatlng().toString());
                i++;
            }
        }
        for (Marker marker : map2.getMarkers()) {
            simpleModel.addOverlay(marker);
        }
    }

    private void formataLatLng(String latlng) {
        String[] result1 = latlng.split(",");

        String[] lat = result1[0].split(":");
        String[] lng = result1[1].split(":");

        this.centerCity = lat[1].toString() + "," + lng[1].toString();
    }
    
    private void setClassificacaoGuia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pontoturistico> getPontoTur() {
        return pontoTur;
    }

    public void setPontoTur(List<Pontoturistico> pontoTur) {
        this.pontoTur = pontoTur;
    }

    public Guia getGuiaAtual() {
        return guiaAtual;
    }

    public void setGuiaAtual(Guia guiaAtual) {
        this.guiaAtual = guiaAtual;
    }

    public String getCenterCity() {
        return centerCity;
    }

    public void setCenterCity(String centerCity) {
        this.centerCity = centerCity;
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
