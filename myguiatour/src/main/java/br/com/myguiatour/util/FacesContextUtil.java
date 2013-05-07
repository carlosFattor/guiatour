package br.com.myguiatour.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class FacesContextUtil {

    public static final String JPA_EM = "jpa_em";

    public static void setRequestSession(EntityManager em) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(JPA_EM, em);
    }

    public static EntityManager getRequestSession() {
        return (EntityManager) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(JPA_EM);
    }
}
