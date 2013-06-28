package com.monitoreo.registros;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;

import com.monitoreo.utilidades.Constantes;
import com.monitoreo.utilidades.JpaUtils;





@Singleton
public class MindsITRegistrar {

 // inicialización basada en EJB 3.x o Spring
 @PersistenceContext(unitName = "solucion")
 private static EntityManager em;

 @Produces
 public EntityManager getEntityManager() {
  // if not initialized by EJB 3.x
  if (em == null) {
   // use the utility class
   em = JpaUtils.getEntityManager(Constantes.NOMBRE_PERSISTENCIA);
  }
  return em;
 }
}