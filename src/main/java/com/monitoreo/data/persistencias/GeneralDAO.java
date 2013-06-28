package com.monitoreo.data.persistencias;
import java.io.Serializable;
import java.util.List;

public interface GeneralDAO<T, ID extends Serializable> {

 T findById(ID id, boolean lock);

 List<T> findAll();

 List<T> findByExample(T exampleInstance);

 T makePersistent(T entity);

 void makeTransient(T entity);
}