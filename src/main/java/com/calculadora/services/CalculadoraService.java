package com.calculadora.services;

import java.math.BigDecimal;

public interface CalculadoraService {

	BigDecimal ejecutar(String operador, BigDecimal ope1, BigDecimal ope2);

}
