package fr.natsystem.examen.services;

public class BusinessException extends Exception {
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		
	}
}