/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.cadponto;

import br.com.myguiatour.entity.Barerest;
import br.com.myguiatour.entity.Entreterimento;
import br.com.myguiatour.entity.Esporte;
import br.com.myguiatour.entity.Estadia;
import br.com.myguiatour.entity.Guia;
import br.com.myguiatour.entity.PontoDefault;
import br.com.myguiatour.entity.Pontoturistico;
import br.com.myguiatour.entity.Transporte;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "cadPontoBB")
@ViewScoped
public class CadPontoBB implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nomePesq;
    private boolean guiaStatus = false;
    private boolean pontoStatus = false;
    private String latitude = "";
    private String longitude = "";
    private String city;
    private String nomeGuia;
    @ManagedProperty(value = "#{guiaAtual}")
    private Guia guiaAtual;
    private PontoDefault pontoDefault;
    private MapModel simpleModel;
    private CadPontoBC cadPontoBC;
    private Marker marker;
    private List<Pontoturistico> listaPontos;
    private Esporte esporte;
    private Entreterimento entreterimento;
    private Estadia estadia;
    private Transporte transporte;
    private Barerest bar;
    private String tipoPonto;
    public static FacesMessage msg;
    
    public CadPontoBB() {
        city = "36.879466, 30.667648";
        simpleModel = new DefaultMapModel();
        esporte = new Esporte();
        entreterimento = new Entreterimento();
        estadia = new Estadia();
        transporte = new Transporte();
        bar = new Barerest();
    }
    
    public void pesqGuia() {
        simpleModel = new DefaultMapModel();
        cadPontoBC = new CadPontoBC();
        this.guiaStatus = cadPontoBC.pesqGuia(nomePesq);
        guiaAtual = cadPontoBC.getGuiaAtual();
        listaPontos = cadPontoBC.getPontoTur();
        RequestContext context = RequestContext.getCurrentInstance();
        if (guiaStatus != false) {
            context.execute("confirmation.show();");
        } else {
            simpleModel = cadPontoBC.addMarkers();
            this.city = cadPontoBC.getCenterCity();
            if (getListaPontos().size() <= 0) {
                context.execute("confPonto.show();");
            }
        }
    }
    
    public void cadastrarGuia() {
        //msg = new FacesMessage("Sucesso", guiaAtual.getNomeGuia() + " Cadastrada");        
        cadPontoBC.cadGuia(this.guiaAtual);        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.guiaStatus = false;
    }

    /**
     * Obter dados da pesquisa do Guia
     */
    public void coordenada() {
        guiaAtual = new Guia();
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> parameterMap = context.getExternalContext().getRequestParameterMap();
        latitude = parameterMap.get("latitude");
        longitude = parameterMap.get("longitude");
        nomeGuia = ((String) parameterMap.get("cidade"));
        getGuiaAtual().setLatlngGuia(latitude + "," + longitude);
    }
    
    
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
    
    public String getNomePesq() {
        return nomePesq;
    }

    public void setNomePesq(String nomePesq) {
        this.nomePesq = nomePesq;
    }

    public boolean isGuiaStatus() {
        return guiaStatus;
    }

    public void setGuiaStatus(boolean guiaStatus) {
        this.guiaStatus = guiaStatus;
    }

    public boolean isPontoStatus() {
        return pontoStatus;
    }

    public void setPontoStatus(boolean pontoStatus) {
        this.pontoStatus = pontoStatus;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNomeGuia() {
        return nomeGuia;
    }

    public void setNomeGuia(String nomeGuia) {
        this.nomeGuia = nomeGuia;
    }

    public Guia getGuiaAtual() {
        return guiaAtual;
    }

    public void setGuiaAtual(Guia guiaAtual) {
        this.guiaAtual = guiaAtual;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public CadPontoBC getCadPontoBC() {
        return cadPontoBC;
    }

    public void setCadPontoBC(CadPontoBC cadPontoBC) {
        this.cadPontoBC = cadPontoBC;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public List<Pontoturistico> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(List<Pontoturistico> listaPontos) {
        this.listaPontos = listaPontos;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public Entreterimento getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(Entreterimento entreterimento) {
        this.entreterimento = entreterimento;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Barerest getBar() {
        return bar;
    }

    public void setBar(Barerest bar) {
        this.bar = bar;
    }

    public String getTipoPonto() {
        return tipoPonto;
    }

    public void setTipoPonto(String tipoPonto) {
        this.tipoPonto = tipoPonto;
    }

    public static FacesMessage getMsg() {
        return msg;
    }

    public static void setMsg(FacesMessage msg) {
        CadPontoBB.msg = msg;
    }

    public PontoDefault getPontoDefault() {
        return pontoDefault;
    }

    public void setPontoDefault(PontoDefault pontoDefault) {
        this.pontoDefault = pontoDefault;
    }
    
}
