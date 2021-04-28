package com.educacionit.jse.integrador.excepciones;

public class CafeStoreException extends Exception{
	private static String mensaje = "Ha ocurrido un problema, intente más tarde";
	
	@Override
	public String getMessage() {
		return mensaje;
	}

}
