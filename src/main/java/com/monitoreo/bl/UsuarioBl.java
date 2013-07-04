package com.monitoreo.bl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.modelo.servicios.UsuariosService;
import com.monitoreo.data.persistencias.UsuarioAccesoDatos;
import com.monitoreo.modelo.Usuarios;
import com.monitoreo.registros.MindsITRegistrar;
import com.monitoreo.utilidades.Constantes;
import com.monitoreo.utilidades.FormatoRespuesta;



public class UsuarioBl {

	private List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
	@Inject
	MindsITRegistrar mindsITRegistrar = new MindsITRegistrar();

	@Inject
	UsuarioAccesoDatos usuariosAccesoDatos;
	

	@Inject
	UsuariosService usuariosService;
	

	public UsuarioBl() {
	}

	/**
	 * Metodo construido para validar la autenticacion de un Usuario
	 * 
	 * @param strUsuaLogin
	 * @param strUsuaPassword
	 * @return
	 */
	public List<Usuarios> validarAutenticacionUsuario(String strUsuaLogin,
			String strUsuaPassword, String strIpAddress) {
		String strSesionId = "";

		usuariosAccesoDatos = new UsuarioAccesoDatos(mindsITRegistrar.getEntityManager());

		listUsuarios = usuariosAccesoDatos.validarAutenticacionUsuario(
				strUsuaLogin, strUsuaPassword,strIpAddress);

		if (!listUsuarios.isEmpty()) {

			strSesionId =Constantes.RESP_CORRECTA;

		} else {
			strSesionId = Constantes.RESP_INCORRECTA;
		}
		return listUsuarios;
	} // Fin validarAutenticacionUsuario

	public boolean registrarUsuario(Usuarios usuarios) {
		boolean blRespuesta = false;
		try {
			if (validarUsuariosCamposObligatorios(usuarios).isBlValidacion()) {
				usuariosService.save(usuarios);
				blRespuesta = true;
			}
		} catch (Exception e) {
			blRespuesta = false;
			e.printStackTrace();
		}
		return blRespuesta;
	}

	public FormatoRespuesta validarUsuariosCamposObligatorios(Usuarios usuarios) {
		FormatoRespuesta respuesta = new FormatoRespuesta();

		try {
			if (usuarios.getLogin() == null
					|| usuarios.getLogin().trim().isEmpty()) {
				respuesta.setBlValidacion(false);
				respuesta.setNuCodigoRespuesta(Constantes.RESP_ERROR);
				respuesta.setStrMensajeRespuesta("Login es Obligatorio");
				return respuesta;
			}
			if (usuarios.getPassword() == null
					|| usuarios.getPassword().trim().isEmpty()) {
				respuesta.setBlValidacion(false);
				respuesta.setNuCodigoRespuesta(Constantes.RESP_ERROR);
				respuesta.setStrMensajeRespuesta("Password es Obligatorio");
				return respuesta;
			}
			if (usuarios.getLogin() != null) {
				if (usuariosAccesoDatos.consultaLogin(usuarios.getLogin()) != null) {
					respuesta.setBlValidacion(false);
					respuesta.setNuCodigoRespuesta(Constantes.RESP_ERROR);
					respuesta
							.setStrMensajeRespuesta("Este Login ya esta registrado");
					return respuesta;
				}
			}
			
		} catch (Exception e) {
			respuesta.setBlValidacion(false);
			e.printStackTrace();
		}
		respuesta.setBlValidacion(true);
		return respuesta;
	}

}