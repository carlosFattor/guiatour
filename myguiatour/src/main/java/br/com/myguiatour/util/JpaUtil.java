package br.com.myguiatour.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */
public class JpaUtil {

    public static final String JPA_EM = "jpa_em";
    private static EntityManagerFactory emf;

    static {
        getEntityManagerFactory();
    }

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("guiatourPU");
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        return emf;
    }
}
