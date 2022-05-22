package com.calculadora.dtos;

import java.math.BigDecimal;

public class ResultadoOperacion {

	String operacion;
	BigDecimal operando1;
	BigDecimal operando2;
	Double resultado;
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public BigDecimal getOperando1() {
		return operando1;
	}
	public void setOperando1(BigDecimal operando1) {
		this.operando1 = operando1;
	}
	public BigDecimal getOperando2() {
		return operando2;
	}
	public void setOperando2(BigDecimal operando2) {
		this.operando2 = operando2;
	}
	public Double getResultado() {
		return resultado;
	}
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
	
}
