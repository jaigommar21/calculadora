package com.calculadora.exceptions;

public class NumeroFueraDeRangoException extends Exception{

	private static final long serialVersionUID = 1L;

	public NumeroFueraDeRangoException() {
		super("Numero fuera de rango permitido");
	}
	public NumeroFueraDeRangoException(String msg) {
		super(msg);
	}
}
