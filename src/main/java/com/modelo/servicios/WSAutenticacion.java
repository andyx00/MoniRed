package com.modelo.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import com.monitoreo.bl.UsuarioBl;
import com.monitoreo.modelo.Estados;
import com.monitoreo.modelo.Roles;
import com.monitoreo.modelo.Usuarios;
import com.monitoreo.utilidades.CodigosError;
import com.monitoreo.utilidades.Constantes;
@Path("/autenticacion")
public class WSAutenticacion {
   private String nombre;
   private String apellido;
   private String email;
   private String password;
   private String area;
   private String login;
   private String departamento;
   private Integer rolid;
   private Integer estadoid;
	
	

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
	   json.put("nombre", listUsuarios.get(0).getUsuanombre());
	   json.put("apellido", listUsuarios.get(0).getUsuapellido());
	   json.put("id", listUsuarios.get(0).getUsuaid());
	   json.put("rol", listUsuarios.get(0).getRoles().getRoldescripcion());
	   json.put("area", listUsuarios.get(0).getArea());
	   json.put("departamento", listUsuarios.get(0).getDepartamento());

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
 @Path("/wsregister/{data}")
 @Produces("application/json")
 public String responseJsonRegister(
   @PathParam("data") JSONObject jsonDatosPerfil) throws JSONException {

  JSONObject json = new JSONObject();
  boolean blRespuesta = false;
  try {
  
   nombre= jsonDatosPerfil.getString("nombre");	  
   apellido= jsonDatosPerfil.getString("apellido");	
   email= jsonDatosPerfil.getString("email");	
   area= jsonDatosPerfil.getString("area");	
   departamento= jsonDatosPerfil.getString("departamento");	
   login = jsonDatosPerfil.getString("login");
   password = jsonDatosPerfil.getString("password");
   rolid = jsonDatosPerfil.getInt("rolid");
   estadoid=jsonDatosPerfil.getInt("estadoid");
   
   Roles rol = new Roles();
   rol.setRolid(rolid);
   Estados estado= new Estados();
   estado.setEstadoid(estadoid);
   
   Usuarios usuario = new Usuarios();
   usuario.setLogin(login);
   usuario.setUsuamail(email);
   usuario.setUsuanombre(nombre);
   usuario.setPassword(password);
   usuario.setUsuapellido(apellido);
   usuario.setArea(area);
   usuario.setDepartamento(departamento);
   usuario.setRoles(rol);
   usuario.setEstados(estado);
   
   
   blRespuesta= new UsuarioBl().registrarUsuario(usuario);
   
   if(blRespuesta){
		json.put(Constantes.TAG_RESPUESTA, CodigosError.RESPUESTA_CORRECTA);

   }else{
	   
	   json.put(Constantes.TAG_RESPUESTA, CodigosError.RESPUESTA_ERROR);
		json.put(Constantes.TAG_CODIGO, CodigosError.ERROR_REGISTRAR.getStrCodigo());
		json.put(Constantes.TAG_MENSAJE, CodigosError.ERROR_REGISTRAR.getStrMensaje());
   }
  

  } catch (Exception exception) {
	  json.put(Constantes.TAG_RESPUESTA, CodigosError.RESPUESTA_ERROR);
	  json.put(Constantes.TAG_CODIGO, CodigosError.ERROR_REGISTRAR.getStrCodigo());
	  json.put(Constantes.TAG_MENSAJE, CodigosError.ERROR_REGISTRAR.getStrMensaje());
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