/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.avaliacoes;

import br.com.myguiatour.dao.HibernateDAO;
import br.com.myguiatour.dao.InterfaceDAO;
import br.com.myguiatour.entity.Avaliaguia;
import br.com.myguiatour.entity.Avaliaponto;
import br.com.myguiatour.entity.Guia;
import br.com.myguiatour.entity.Pontoturistico;
import br.com.myguiatour.util.FacesContextUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class AvaliacoesBC {

    List<Avaliaguia> avaliaGuia;
    List<Avaliaponto> avaliaPonto;
    List<Guia> listaGuia;
    List<Guia> listaRetorno;
    List<Pontoturistico> pontoRetorno;
    float total;

    private InterfaceDAO<Avaliaguia> avaliaGuiaDAO() {
        InterfaceDAO<Avaliaguia> avaliaGuiaDAO = new HibernateDAO<Avaliaguia>(Avaliaguia.class, FacesContextUtil.getRequestSession());
        return avaliaGuiaDAO;
    }

    private InterfaceDAO<Avaliaponto> avaliaPontoDAO() {
        InterfaceDAO<Avaliaponto> avaliaPontoDAO = new HibernateDAO<Avaliaponto>(Avaliaponto.class, FacesContextUtil.getRequestSession());
        return avaliaPontoDAO;
    }

    public List<Guia> setClassificacaoGuia(List<Guia> listaGuias) {
        listaRetorno = new ArrayList<Guia>();
        avaliaGuia = new ArrayList<Avaliaguia>();
        for (Guia guia : listaGuias) {
            avaliaGuia = avaliaGuiaDAO().getEntitysByIds(guia.getIdUsuario(), guia.getIdGuia(), "Avaliaguia.findByIdUsuarioIdGuia", "idUsuario", "idGuia");
            guia.setClassificacao((Integer) this.calcMediaGuia(avaliaGuia));
            listaRetorno.add(guia);
        }

        return listaRetorno;
    }

    public List<Pontoturistico> setClassificacaoPonto(List<Pontoturistico> pontoEnc) {
        pontoRetorno = new ArrayList<Pontoturistico>();
        avaliaPonto = new ArrayList<Avaliaponto>();
        for (Pontoturistico ponto : pontoEnc) {
            avaliaPonto = avaliaPontoDAO().getEntitysByIds(ponto.getIdUsuario(), ponto.getIdGuia(), "Avaliaponto.findByIdUsuarioIdGuia", "idUsuario", "idGuia");
            ponto.setClassificacao((Integer) this.calcMediaPonto(avaliaPonto));
            pontoRetorno.add(ponto);
        }
        return pontoRetorno;
    }

    private Integer calcMediaGuia(List<Avaliaguia> avaliacoes) {
        total = (float) 0.0;
        for (Avaliaguia guia : avaliacoes) {
            total += guia.getNota();
        }
        return Math.round(total = total / avaliacoes.size());
    }

    private Integer calcMediaPonto(List<Avaliaponto> avaliacoes) {
        total = (float) 0.0;
        for (Avaliaponto ponto : avaliacoes) {
            total += ponto.getNota();
        }
        return Math.round(total = total / avaliacoes.size());
    }
}
