package com.modelo.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import com.monitoreo.bl.UsuarioBl;
import com.monitoreo.modelo.Usuarios;
@Path("/autenticacion")
public class WSAutenticacion {
 

 @GET
 @Path("/json/{data}")
 @Produces("application/json")
 public String responseJson(
   @PathParam("data") JSONObject jsonDatosPerfil) {

  JSONObject json = new JSONObject();
  try {

   String strUsuaLogin = jsonDatosPerfil.getString("login");
   String strUsuaPassword = jsonDatosPerfil.getString("password");
   String strIpAddress = jsonDatosPerfil.getString("ipaddress");
   List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
   listUsuarios = new UsuarioBl().validarAutenticacionUsuario(
     strUsuaLogin, strUsuaPassword, strIpAddress);
   if(listUsuarios.size()>0){
	   json.put("respuesta", listUsuarios.get(0).getLogin());
	   System.out.println("[" + listUsuarios.get(0).getLogin() + "]");
   }else{
	   json.put("respuesta", "-10");
   }
  

  } catch (Exception exception) {
   exception.printStackTrace();
  }

  return json.toString();
 }

 @GET
 @Path("/xml")
 @Produces("application/xml")
 public String responseXml() {
  return "<mi-mensaje>true</mi-mensaje>";
 }
 
}