package com.modelo.servicios;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import com.monitoreo.bl.UsuarioBl;
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

   String strSessionId = new UsuarioBl().validarAutenticacionUsuario(
     strUsuaLogin, strUsuaPassword, strIpAddress);
   json.put("respuesta", strSessionId);
   System.out.println("[" + strSessionId + "]");

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