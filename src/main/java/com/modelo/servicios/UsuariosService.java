package com.modelo.servicios;

import java.io.Serializable;
import java.math.BigInteger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

import com.monitoreo.data.persistencias.UsuarioAccesoDatos;
import com.monitoreo.modelo.Usuarios;
@Named
@Dependent
public class UsuariosService implements Serializable {
 private static final long serialVersionUID = 1L;

 @Inject
 UsuarioAccesoDatos usuarioAccesoDatos;

 public void save(Usuarios usuarios) {

  try {
   usuarioAccesoDatos.beginTransaction();
   usuarioAccesoDatos.makePersistent(usuarios);
   usuarioAccesoDatos.commit();

  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 public Integer nextValueSequence() {
  try {
   String queryString = "select nextval('MonitoreoRed.usuarios_usuaid_seq')";
   usuarioAccesoDatos.beginTransaction();
   Query queryObject = usuarioAccesoDatos.executeQuery(queryString);
   usuarioAccesoDatos.commit();

   return ((BigInteger) queryObject.getParameterValue(0)).intValue();
  } catch (RuntimeException re) {
   throw re;
  }
 }
}