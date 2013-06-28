package com.monitoreo.utilidades;

public class FormatoRespuesta {

	 private Integer nuCodigoRespuesta;
	 private String strMensajeRespuesta;
	 private boolean blValidacion;

	 public FormatoRespuesta() {

	 }

	 public FormatoRespuesta(Integer nuCodigoRespuesta,
	   String strMensajeRespuesta, boolean blValidacion) {
	  super();
	  this.nuCodigoRespuesta = nuCodigoRespuesta;
	  this.strMensajeRespuesta = strMensajeRespuesta;
	  this.blValidacion = blValidacion;
	 }

	 public boolean isBlValidacion() {
	  return blValidacion;
	 }

	 public void setBlValidacion(boolean blValidacion) {
	  this.blValidacion = blValidacion;
	 }

	 public Integer getNuCodigoRespuesta() {
	  return nuCodigoRespuesta;
	 }

	 public void setNuCodigoRespuesta(Integer nuCodigoRespuesta) {
	  this.nuCodigoRespuesta = nuCodigoRespuesta;
	 }

	 public String getStrMensajeRespuesta() {
	  return strMensajeRespuesta;
	 }

	 public void setStrMensajeRespuesta(String strMensajeRespuesta) {
	  this.strMensajeRespuesta = strMensajeRespuesta;
	 }

	}