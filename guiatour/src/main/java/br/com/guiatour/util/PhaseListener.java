package br.com.guiatour.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class PhaseListener implements javax.faces.event.PhaseListener{

    @Override
    public void afterPhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("Antes da fase: "+getPhaseId().toString());
            Session session = JpaUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Depois da fase: "+getPhaseId().toString());
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    
}