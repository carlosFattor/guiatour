/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.cadponto;

import br.com.myguiatour.avaliacoes.AvaliacoesBC;
import br.com.myguiatour.dao.HibernateDAO;
import br.com.myguiatour.dao.InterfaceDAO;
import br.com.myguiatour.entity.Barerest;
import br.com.myguiatour.entity.Entreterimento;
import br.com.myguiatour.entity.Esporte;
import br.com.myguiatour.entity.Estadia;
import br.com.myguiatour.entity.Guia;
import br.com.myguiatour.entity.PontoDefault;
import br.com.myguiatour.entity.Pontoturistico;
import br.com.myguiatour.entity.Transporte;
import br.com.myguiatour.util.FacesContextUtil;
import java.util.ArrayList;
import java.util.Calendar;
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
    //private HibernateDAO cadPontos;
    private MapModel simpleModel;
    private String centerCity;
    private MapModel advancedModel;
    @ManagedProperty(value = "#{avaliacoesBC}")
    private AvaliacoesBC avaliacoesBC;
    Calendar data = Calendar.getInstance();
    List<Pontoturistico> pontoEnc;
    
    
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

        if (listaGuias.size() > 0) {
            this.setClassificacaoGuia();
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
        pontoTur = new ArrayList<Pontoturistico>();
        for (Guia guia : listaGuias) {
            pontoEnc = new ArrayList<Pontoturistico>();
            pontoEnc = (List<Pontoturistico>) pontoDAO().getEntitysId(guia.getIdGuia(), "Pontoturistico.findByIdGuia", "idGuia");
            pontoEnc = this.setClassificacaoPonto();
            for (Pontoturistico ponto : pontoEnc) {
                pontoTur.add(ponto);
            }
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
        if (pontoTur != null && pontoTur.size() > 0) {
            for (Pontoturistico ponto : pontoTur) {
                String coord[] = ponto.getLatlngPonto().split(",");

                LatLng latlng = new LatLng(Double.parseDouble(coord[0]), Double.parseDouble(coord[1]));

                Integer rating = ponto.getClassificacao();
                pontoTur.get(i).setClassificacao(rating);

                advancedModel.addOverlay(new Marker(latlng, ponto.getNomePonto(), ponto));

            }
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
        avaliacoesBC = new AvaliacoesBC();
        listaGuias = avaliacoesBC.setClassificacaoGuia(listaGuias);
    }
    
    private List<Pontoturistico> setClassificacaoPonto() {
        return avaliacoesBC.setClassificacaoPonto(pontoEnc);
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

    

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    void cadPontoEstadia(PontoDefault pontoDefault, Estadia estadia) {
        estadia = this.preencheEstadia(pontoDefault, estadia);
        try {
            pontoDAO().save(estadia);
            
            CadPontoBB.msg = new FacesMessage("Sucesso", pontoDefault.getNomePonto() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", pontoDefault.getNomePonto() + " Não Cadastrada");
        }
    }

    private Estadia preencheEstadia(PontoDefault pontoDefault, Estadia estadia) {
        estadia.setNomePonto(pontoDefault.getNomePonto());
        estadia.setFotoPonto1(pontoDefault.getFotoPonto1());
        estadia.setFotoPonto2(pontoDefault.getFotoPonto2());
        estadia.setFotoPonto3(pontoDefault.getFotoPonto3());
        estadia.setInfoPonto(pontoDefault.getInfoPonto());
        estadia.setComentarioPonto(pontoDefault.getComentarioPonto());
        estadia.setUrlPonto(pontoDefault.getUrlPonto());
        estadia.setDataCadPonto(pontoDefault.getDataCadPonto());

        return estadia;
    }

    void cadPontoEntreterimento(PontoDefault pontoDefault, Entreterimento entreterimento) {
        entreterimento = this.preencheEntreterimento(pontoDefault, entreterimento);
        try {
            pontoDAO().save(entreterimento);
            CadPontoBB.msg = new FacesMessage("Sucesso", pontoDefault.getNomePonto() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", pontoDefault.getNomePonto() + " Não Cadastrada");
        }
    }

    private Entreterimento preencheEntreterimento(PontoDefault ponto, Entreterimento entre) {
        entre.setNomePonto(ponto.getNomePonto());
        entre.setFotoPonto1(ponto.getFotoPonto1());
        entre.setFotoPonto2(ponto.getFotoPonto2());
        entre.setFotoPonto3(ponto.getFotoPonto3());
        entre.setInfoPonto(ponto.getInfoPonto());
        entre.setComentarioPonto(ponto.getComentarioPonto());
        entre.setUrlPonto(ponto.getUrlPonto());
        entre.setDataCadPonto(ponto.getDataCadPonto());

        return entre;
    }

    void cadPontoBar(PontoDefault pontoDefault, Barerest bar) {
        bar = this.preencheBar(pontoDefault, bar);
        try {
            pontoDAO().save(bar);
            CadPontoBB.msg = new FacesMessage("Sucesso", pontoDefault.getNomePonto() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", pontoDefault.getNomePonto() + " Não Cadastrada");
        }
    }

    private Barerest preencheBar(PontoDefault ponto, Barerest bar) {
        bar.setNomePonto(ponto.getNomePonto());
        bar.setFotoPonto1(ponto.getFotoPonto1());
        bar.setFotoPonto2(ponto.getFotoPonto2());
        bar.setFotoPonto3(ponto.getFotoPonto3());
        bar.setInfoPonto(ponto.getInfoPonto());
        bar.setComentarioPonto(ponto.getComentarioPonto());
        bar.setUrlPonto(ponto.getUrlPonto());
        bar.setDataCadPonto(ponto.getDataCadPonto());

        return bar;
    }

    void cadPontoTransporte(PontoDefault pontoDefault, Transporte transporte) {
        transporte = this.preencheTransporte(pontoDefault, transporte);
        try {
            pontoDAO().save(transporte);
            CadPontoBB.msg = new FacesMessage("Sucesso", pontoDefault.getNomePonto() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", pontoDefault.getNomePonto() + " Não Cadastrada");
        }
    }

    private Transporte preencheTransporte(PontoDefault ponto, Transporte transporte) {
        transporte.setNomePonto(ponto.getNomePonto());
        transporte.setFotoPonto1(ponto.getFotoPonto1());
        transporte.setFotoPonto2(ponto.getFotoPonto2());
        transporte.setFotoPonto3(ponto.getFotoPonto3());
        transporte.setInfoPonto(ponto.getInfoPonto());
        transporte.setComentarioPonto(ponto.getComentarioPonto());
        transporte.setUrlPonto(ponto.getUrlPonto());
        transporte.setDataCadPonto(ponto.getDataCadPonto());

        return transporte;
    }

    void cadPontoEsporte(PontoDefault pontoDefault, Esporte esporte) {
        esporte = this.preencheEsporte(pontoDefault, esporte);
        try {
            pontoDAO().save(esporte);
            CadPontoBB.msg = new FacesMessage("Sucesso", pontoDefault.getNomePonto() + " Cadastrada");
        } catch (Exception e) {
            CadPontoBB.msg = new FacesMessage("Erro", pontoDefault.getNomePonto() + " Não Cadastrada");
        }
    }

    private Esporte preencheEsporte(PontoDefault ponto, Esporte esporte) {
        esporte.setNomePonto(ponto.getNomePonto());
        esporte.setFotoPonto1(ponto.getFotoPonto1());
        esporte.setFotoPonto2(ponto.getFotoPonto2());
        esporte.setFotoPonto3(ponto.getFotoPonto3());
        esporte.setInfoPonto(ponto.getInfoPonto());
        esporte.setComentarioPonto(ponto.getComentarioPonto());
        esporte.setUrlPonto(ponto.getUrlPonto());
        esporte.setDataCadPonto(ponto.getDataCadPonto());

        return esporte;
    }

    
}
