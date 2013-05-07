/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myguiatour.avaliacoes;

import br.com.myguiatour.dao.HibernateDAO;
import br.com.myguiatour.dao.InterfaceDAO;
import br.com.myguiatour.entity.Avaliaguia;
import br.com.myguiatour.entity.Guia;
import br.com.myguiatour.util.FacesContextUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class AvaliacoesBC {

    
    List<Avaliaguia> avaliacoes;
    List<Guia> listaGuia;
    List<Guia> listaRetorno;
    float total;

    private InterfaceDAO<Avaliaguia> avaliaDAO() {
        InterfaceDAO<Avaliaguia> avaliaDAO = new HibernateDAO<Avaliaguia>(Avaliaguia.class, FacesContextUtil.getRequestSession());
        return avaliaDAO;
    }

    public List<Guia> setClassificacao(List<Guia> listaGuias) {
        listaRetorno = new ArrayList<Guia>();
        avaliacoes = new ArrayList<Avaliaguia>();
        for (Guia guia : listaGuias) {
            avaliacoes = avaliaDAO().getEntitysByIds(guia.getIdUsuario(), guia.getIdGuia(), "Avaliaguia.findByIdUsuarioIdGuia", "idUsuario", "idGuia");
            guia.setClassificacao((Integer)this.calcMedia(avaliacoes));
            listaRetorno.add(guia);
        }

        return listaRetorno;
    }

    private Integer calcMedia(List<Avaliaguia> avaliacoes) {
        total = (float) 0.0;
        for (Avaliaguia guia : avaliacoes) {
            total += guia.getNota();
        }
        return Math.round(total = total / avaliacoes.size());
    }
}
