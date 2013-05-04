package br.com.guiatour.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Carlos
 */
public interface InterfaceDAO<T> {

    void save(T entity);
    void update(T entity);
    boolean remove(T entity);
    boolean merge(T entity);
    T getEntity(Serializable id);
    T getEntityByDeatchedCriteria(DetachedCriteria criteria);
    List<T> getEntitys();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    
}
