package br.com.myguiatour.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class PhaseListener implements javax.faces.event.PhaseListener{

    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Antes da fase: "+fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {  
            EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
            FacesContextUtil.setRequestSession(em);
        }
    }

    @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Depois da fase: "+fase.getPhaseId());
            EntityManager em = FacesContextUtil.getRequestSession();            
            try {
                em.getTransaction().commit();                
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }finally{
                em.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    } 
}
