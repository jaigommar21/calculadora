package com.calculadora.exceptions;

public class OperationNotSupportException extends Exception{

	private static final long serialVersionUID = 1L;

	public OperationNotSupportException() {
		super("Operacion no soportada");
	}
	public OperationNotSupportException(String msg) {
		super(msg);
	}
}
