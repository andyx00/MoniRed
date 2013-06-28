package com.monitoreo.utilidades;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
public class Utilidades {

	 /**
	  * Metodo construido para sumar Minutos a Determinada Fecha Timestamp
	  * 
	  * @param fecha
	  * @param cantMinutos
	  * @return
	  */
	 public static java.sql.Timestamp addMinutos(java.sql.Timestamp fecha,
	   int cantMinutos) {
	  GregorianCalendar gc = new GregorianCalendar();
	  gc.setTime(fecha);
	  gc.add(Calendar.MINUTE, cantMinutos);
	  return new java.sql.Timestamp(gc.getTime().getTime());
	 }// FIN addMinutos

	 /**
	  * Metodo construido para generar una Cadena alfanumerica randomicamente
	  * 
	  * @param longitud
	  * @return
	  */
	 public final static String randomString(int length) {
	  String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIFKLMNOPRSTUVWXYZ0123456789";
	  StringBuffer buf = new StringBuffer(length);
	  for (int i = 0; i < length; ++i) {
	   int pos = (int) Math.round(Math.random() * (chars.length() - 1));
	   buf.append(chars.charAt(pos));
	  }
	  return buf.toString();
	 }// FIN randomString

	 /**
	  * Metodo construido para convertir una cadena a Date
	  * 
	  * @param strFecha
	  * @param strFormato
	  * @return
	  */
	 public static Date convertirStringToDate(String strFecha, String strFormato) {
	  Date dtFecha = null;
	  SimpleDateFormat formatoDelTexto = new SimpleDateFormat(strFormato);
	  try {
	   dtFecha = formatoDelTexto.parse(strFecha);
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  }
	  return dtFecha;
	 } // Fin convertirStringToDate
	}