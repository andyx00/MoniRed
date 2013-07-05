package com.monitoreo.utilidades;



public class CodigosError {
	
	public static String RESPUESTA_CORRECTA = "1";
	public static String RESPUESTA_ERROR = "-1";
	
	public static ClaseError SESSION_VENCIDA = new ClaseError("9999", "La Session ha expirado");
	
	public static ClaseError ERROR_INTERNO = new ClaseError("1000", "Error");	
	
	public static ClaseError ERROR_CAMPOBLIGATORIO_NOMBRE = new ClaseError("0001", "Nombre obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_APELLIDO = new ClaseError("0002", "Apellido obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_LOGIN = new ClaseError("0003", "Login obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_PASSWORD = new ClaseError("0004", "Password obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_ID_PERFIL = new ClaseError("0005", "Perfil obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_EMAIL = new ClaseError("0006", "Email obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_ID_PAIS = new ClaseError("0007", "Pais obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_ESTADO = new ClaseError("0008", "Estado obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_TIPO = new ClaseError("0009", "Tipo obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_TIPOGRUPO = new ClaseError("0010", "Grupo de Tipo obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_ID = new ClaseError("0011", "Id obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_HOST = new ClaseError("0012", "obligatorio Host");
	public static ClaseError ERROR_CAMPOBLIGATORIO_USERNAME = new ClaseError("0013", "obligatorio Correo por el que se envia");
	public static ClaseError ERROR_CAMPOBLIGATORIO_FROM = new ClaseError("0015", "obligatorio De");
	public static ClaseError ERROR_CAMPOBLIGATORIO_TO = new ClaseError("0016", "obligatorio Para");
	public static ClaseError ERROR_CAMPOBLIGATORIO_SUBJECT = new ClaseError("0017", "obligatorio Asunto");
	public static ClaseError ERROR_CAMPOBLIGATORIO_MESSAGEBODY = new ClaseError("0018", "obligatorio Mensaje");
	public static ClaseError ERROR_CAMPOBLIGATORIO_CODIGO = new ClaseError("0019", "Codigo obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_LOTE = new ClaseError("0020", "Lote obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_USUARIO = new ClaseError("0021", "Usuario obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_FINCA = new ClaseError("0022", "Finca obligatoria");
	public static ClaseError ERROR_CAMPOBLIGATORIO_CULTIVO = new ClaseError("0023", "Cultivo obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_USUARIOCREADOR = new ClaseError("0024", "Usuario Creador obligatorio");
	public static ClaseError ERROR_CAMPOBLIGATORIO_VARIEDAD = new ClaseError("0025", "Variedad obligatoria");
	public static ClaseError ERROR_CAMPOBLIGATORIO_TRATAMIENTO = new ClaseError("0026", "Tratamiento obligatorio");
	
	public static ClaseError ERROR_CAMPOREPETIDO_EMAIL = new ClaseError("0500", "Email ya registrado");
	public static ClaseError ERROR_CAMPOREPETIDO_LOGIN = new ClaseError("0501", "Login ya registrado");
	
	public static ClaseError ERROR_NOEXISTE_USUARIO = new ClaseError("0600", "No existen registros");
	public static ClaseError ERROR_NOEXISTE_REGISTROSESSION = new ClaseError("0601", "No existe registro de Session");
	
	public static ClaseError ERROR_REGISTRAR = new ClaseError("0700", "Registro Fallido");
	public static ClaseError ERROR_EDITAR = new ClaseError("0701", "Edicion Fallida");
	public static ClaseError ERROR_ELIMINAR = new ClaseError("0702", "Eliminacion Fallida");
	public static ClaseError ERROR_CUENTAVERIFICADA = new ClaseError("0703", "El correo Electronico no ha sido Verificado");
	public static ClaseError ERROR_AUTENTICACION = new ClaseError("0704", "Error Datos de Autenticacion");
	
	

	
}
