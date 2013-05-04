package br.com.guiatour.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Carlos
 */
public class JpaUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            System.out.println("tentando abrir uma sessionfactory");
            Configuration conf = new Configuration().configure();
            ServiceRegistry serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
            
            sessionFactory = conf.buildSessionFactory(serviceRegistryBuilder);
            
            System.out.println("Session factory criada com sucesso");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao iniciar SF." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
