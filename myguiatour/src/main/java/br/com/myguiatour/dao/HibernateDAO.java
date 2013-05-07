
package br.com.myguiatour.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable{

    private static final long serialVersionUID = 1L;    
    
    private Class<T> classe;
    private EntityManager em;
    EntityTransaction tx;

    public HibernateDAO(Class<T> classe, EntityManager em) {
        super();
        this.classe = classe;
        this.em = em;
    }
    
    @Override
    public void beginTransaction() {
        tx = this.em.getTransaction();
        tx.begin();
    }

    @Override
    public void commitTransaction() {
        tx.commit();        
    }
    @Override
    public void save(T entity) {
        try {
            this.beginTransaction();
            em.persist(entity);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }        
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public boolean remove(T entity) {
        try {
            em.remove(entity);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao remover objeto " + e);
            return false;
        }
        
    }

    @Override
    public boolean merge(T entity) {
        try {
            em.merge(entity);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao dar update no objeto "+e);
            return false;
        }
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T)em.find(classe, id);
        return entity;
    }

    @Override
        public List<T> getEntitys(String nomePesq, String namedQuery, String atr) {
        Query q = this.em.createNamedQuery(namedQuery, classe);
        q.setParameter(atr, nomePesq);
        List<T> lista = q.getResultList();
        return lista;
    }

    @Override
    public List<T> getEntitysByIds(Integer IdUser, Integer IdGuia, String namedQuery, String atr1, String atr2) {
        Query q = this.em.createNamedQuery(namedQuery, classe)
        .setParameter( atr1, IdUser)
        .setParameter(atr2, IdGuia);
        List<T> lista = q.getResultList();
        return lista;
    }

    @Override
    public List<T> getEntitysId(Integer id, String namedQuery, String atr) {
        Query q = this.em.createNamedQuery(namedQuery, classe)
        .setParameter(atr, id);
        List<T> lista = q.getResultList();
        return lista;
    }
}
