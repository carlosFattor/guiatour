package br.com.myguiatour.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface InterfaceDAO<T> {

    public void beginTransaction();
    public void commitTransaction();
    void save(T entity);
    void update(T entity);
    boolean remove(T entity);
    boolean merge(T entity);
    T getEntity(Serializable id);      
    List<T> getEntitys(String nomePesq, String namedQuery, String atributo);    
}
