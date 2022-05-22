package com.calculadora.services;

import java.math.BigDecimal;

public interface CalculadoraService {

	Double ejecutar(String operador, BigDecimal ope1, BigDecimal ope2) throws Exception;

}
