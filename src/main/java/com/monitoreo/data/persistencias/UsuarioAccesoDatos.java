package com.monitoreo.data.persistencias;

import java.util.List;

import javax.persistence.EntityManager;

import com.monitoreo.modelo.Usuarios;

import static com.monitoreo.utilidades.FluentMap.Map;
import static  com.monitoreo.utilidades.FluentMap.entry;




public class UsuarioAccesoDatos extends GeneralJpaDAO<Usuarios, Long> {

 public UsuarioAccesoDatos() {
  super();
 }

 public UsuarioAccesoDatos(EntityManager em) {
  super(em);
 }

 @SuppressWarnings("unchecked")
 public List<Usuarios> validarAutenticacionUsuario(String strUsuaLogin,
   String strUsuaPassword, String strIpaddres) {

  return executeListResultNamedQuery(
    "usuarios.autenticacion",
    Map(entry("login", strUsuaLogin),
      entry("password", strUsuaPassword),
      entry("ip", strIpaddres) ));
 }

 @SuppressWarnings("unchecked")
 public Usuarios consultaLogin(String strUsuaLogin) {

  return executeSingleResultNamedQuery("usuarios.login",
    Map(entry("login", strUsuaLogin)));
 }
}