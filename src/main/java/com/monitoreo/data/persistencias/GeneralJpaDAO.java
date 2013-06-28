package com.monitoreo.data.persistencias;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GeneralJpaDAO<T, ID extends Serializable> implements
		GeneralDAO<T, ID> {

	private Class<T> persistentClass;

	private String persistentClassName = null;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public GeneralJpaDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GeneralJpaDAO(EntityManager em) {
		this();
		this.em = em;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public String getPersistentClassName() {
		if (persistentClassName == null) {
			persistentClassName = getPersistentClass().getName().substring(
					getPersistentClass().getPackage().getName().length() + 1);

		}
		return persistentClassName;
	}

	// control de transacciones

	public void beginTransaction() {
		// inicia una transaccion
		em.getTransaction().begin();
	}

	public void commit() {
		// hace commit de la transaccion
		em.getTransaction().commit();
	}

	public void rollback() {
		try {
			// hace rollback de la transaccion
			em.getTransaction().rollback();
		} catch (Exception e) {
			// no haga nada
		}
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

	// operaciones CRUD

	public T makePersistent(T entity) {
		em.persist(entity);
		return entity;
	}

	public T makeMerge(T entity) {
		em.merge(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		em.remove(entity);
	}

	public T findById(ID id) {
		return findById(id, false);
	}

	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) em.find(getPersistentClass(), id);
			em.lock(entity, LockModeType.WRITE);
		} else {
			entity = em.find(getPersistentClass(), id);
		}

		return entity;
	}

	public void deleteAll() {
		List<T> all = findAll();
		beginTransaction();
		for (T element : all) {
			makeTransient(element);
		}
		commit();
	}

	// simple queries

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		// in Hibernate you can use complete name
		// getPersistentClass().getName()
		// in EclipseLink it is not possible

		Query query = em.createQuery("select x from "
				+ getPersistentClassName() + " x ");
		return query.getResultList();
	}

	// query by example

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByExample(T exampleInstance) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> consulta = cb.createQuery(getPersistentClass());
		Root<T> objectToReturn = consulta.from(getPersistentClass());
		consulta.select(objectToReturn);

		TypedQuery<T> consulta2 = em.createQuery(consulta);
		List resultados = consulta2.getResultList();
		return resultados;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> consulta = cb.createQuery(getPersistentClass());
		Root<T> objectToReturn = consulta.from(getPersistentClass());
		consulta.select(objectToReturn);

		TypedQuery<T> consulta2 = em.createQuery(consulta);
		List resultados = consulta2.getResultList();
		return resultados;
	}

	// queries support

	@SuppressWarnings("unchecked")
	public T executeSingleResultNamedQuery(String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		T resultado = (T) consulta.getSingleResult();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public T executeSingleResultNamedQuery(String namedQuery, Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for (Object param : params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for (String paramName : map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			T resultado = (T) consulta.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> executeListResultNamedQuery(String namedQuery) {
		Query consulta = em.createNamedQuery(namedQuery);
		List<T> resultado = consulta.getResultList();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<T> executeListResultNamedQuery(String namedQuery,
			Object... params) {
		Query consulta = em.createNamedQuery(namedQuery);
		int paramNumber = 0;
		for (Object param : params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for (String paramName : map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			List<T> resultado = consulta.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T executeSingleResultQuery(String query) {
		Query consulta = em.createQuery(query);
		T resultado = (T) consulta.getSingleResult();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public T executeSingleResultQuery(String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for (Object param : params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for (String paramName : map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			T resultado = (T) consulta.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> executeListResultQuery(String query) {
		Query consulta = em.createQuery(query);
		List<T> resultado = consulta.getResultList();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<T> executeListResultQuery(String query, Object... params) {
		Query consulta = em.createQuery(query);
		int paramNumber = 0;
		for (Object param : params) {
			if (param instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) param;
				for (String paramName : map.keySet()) {
					consulta.setParameter(paramName, map.get(paramName));
				}
			} else {
				consulta.setParameter(paramNumber++, param);
			}
		}
		try {
			List<T> resultado = consulta.getResultList();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Query executeQuery(String query) {
		Query consulta = em.createQuery(query);
		return consulta;
	}
	 @SuppressWarnings("unchecked")
	 public List<Object[]> consultaQueryPlagas(String query) {
	  List<Object[]> list = null;
	  try {
	   list = em.createQuery(query).getResultList();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return list;
	 }
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultaQueryVistas(String query) {
		List<Object[]> list = null;
		try {
			list = em.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
