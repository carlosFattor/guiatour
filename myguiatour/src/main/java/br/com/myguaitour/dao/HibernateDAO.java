
package br.com.guiatour.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Carlos
 */
public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable{

    private static final long serialVersionUID = 1L;    
    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }
    
    
    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public boolean remove(T entity) {
        try {
            session.delete(entity);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao remover objeto " + e);
            return false;
        }
        
    }

    @Override
    public boolean merge(T entity) {
        try {
            session.merge(entity);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao dar update no objeto "+e);
            return false;
        }
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T)session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByDeatchedCriteria(DetachedCriteria criteria) {
        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntitys() {
        List<T> entitys = (List<T>)session.createCriteria(classe).list();
        return entitys;
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }    
}
