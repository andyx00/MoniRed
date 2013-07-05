package com.monitoreo.utilidades;

public class ClaseError {

	private String strCodigo;
	private String strMensaje;

	public ClaseError() {

	}

	public ClaseError(String strCodigo, String strMensaje) {
		super();
		this.strCodigo = strCodigo;
		this.strMensaje = strMensaje;
	}

	public String getStrCodigo() {
		return strCodigo;
	}

	public void setStrCodigo(String strCodigo) {
		this.strCodigo = strCodigo;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}
}